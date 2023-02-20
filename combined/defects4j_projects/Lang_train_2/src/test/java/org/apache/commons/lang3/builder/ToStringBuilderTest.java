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
package org.apache.commons.lang3.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;
import org.junit.After;
import org.junit.Test;

/**
 * Unit tests for {@link org.apache.commons.lang3.builder.ToStringBuilder}.
 *
 * @version $Id$
 */
public class ToStringBuilderTest {

    private final Integer base = Integer.valueOf(5);
    private final String baseStr = base.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(base));

    /*
     * All tests should leave the registry empty. 
     */
    @After
    public void after(){
        validateNullToStringStyleRegistry();
    }

    //-----------------------------------------------------------------------

@Test
public void testFloatArrayArray377() { 
     float[][] array = new float[][] { { 1.0f, 2.29686f }, null, { Float.NaN } }; 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testGetSetDefault378() { 
     try { 
         ToStringBuilder.setDefaultStyle(ToStringStyle.NO_FIELD_NAMES_STYLE); 
         assertSame(ToStringStyle.NO_FIELD_NAMES_STYLE, ToStringBuilder.getDefaultStyle()); 
     } finally { 
         ToStringBuilder.setDefaultStyle(ToStringStyle.DEFAULT_STYLE); 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testSetDefaultEx379() { 
     ToStringBuilder.setDefaultStyle(null); 
 }
@Test
public void testReflectionFloatArray380() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 }
@Test
public void testReflectionHierarchy381() { 
     final ReflectionTestFixtureA baseA = new ReflectionTestFixtureA(); 
     String baseStr = this.toBaseString(baseA); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false)); 
     assertEquals(baseStr + "[a=a,transientA=t]", ToStringBuilder.reflectionToString(baseA, null, true)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, null)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, Object.class)); 
     assertEquals(baseStr + "[a=a]", ToStringBuilder.reflectionToString(baseA, null, false, ReflectionTestFixtureA.class)); 
     final ReflectionTestFixtureB baseB = new ReflectionTestFixtureB(); 
     baseStr = this.toBaseString(baseB); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false)); 
     assertEquals(baseStr + "[b=b,transientB=t,a=a,transientA=t]", ToStringBuilder.reflectionToString(baseB, null, true)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, Object.class)); 
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureA.class)); 
     assertEquals(baseStr + "[b=b]", ToStringBuilder.reflectionToString(baseB, null, false, ReflectionTestFixtureB.class)); 
 }
@Test
public void testAppendToStringUsingMultiLineStyle382() { 
     final MultiLineTestObject obj = new MultiLineTestObject(); 
     final ToStringBuilder testBuilder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).appendToString(obj.toString()); 
     assertEquals(testBuilder.toString().indexOf("testInt=31337"), -1); 
 }
@Test
public void testBoolean383() { 
     assertEquals(baseStr + "[true]", new ToStringBuilder(base).append(true).toString()); 
     assertEquals(baseStr + "[a=true]", new ToStringBuilder(base).append("a", true).toString()); 
     assertEquals(baseStr + "[a=true,b=false]", new ToStringBuilder(base).append("a", true).append("b", false).toString()); 
 }
@Test
public void testBooleanArray384() { 
     boolean[] array = new boolean[] { true, false, false }; 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{true,false,false}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testByte385() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((byte) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (byte) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (byte) 3).append("b", (byte) 4).toString()); 
 }
@Test
public void testByteArray386() { 
     byte[] array = new byte[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testChar387() { 
     assertEquals(baseStr + "[A]", new ToStringBuilder(base).append((char) 65).toString()); 
     assertEquals(baseStr + "[a=A]", new ToStringBuilder(base).append("a", (char) 65).toString()); 
     assertEquals(baseStr + "[a=A,b=B]", new ToStringBuilder(base).append("a", (char) 65).append("b", (char) 66).toString()); 
 }
@Test
public void testCharArray388() { 
     char[] array = new char[] { 'A', '2', '_', 'D' }; 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{A,2,_,D}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@SuppressWarnings("cast")
@Test
public void testDouble389() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (double) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (double) 3.2).append("b", (double) 4.3).toString()); 
 }
@Test
public void testDoubleArray390() { 
     double[] array = new double[] { 1.0, 2.9876, -3.00001, 4.3 }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testFloat391() { 
     assertEquals(baseStr + "[3.2]", new ToStringBuilder(base).append((float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2]", new ToStringBuilder(base).append("a", (float) 3.2).toString()); 
     assertEquals(baseStr + "[a=3.2,b=4.3]", new ToStringBuilder(base).append("a", (float) 3.2).append("b", (float) 4.3).toString()); 
 }
@Test
public void testFloatArray392() { 
     float[] array = new float[] { 1.0f, 2.9876f, -3.00001f, 4.3f }; 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1.0,2.9876,-3.00001,4.3}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 } 
@SuppressWarnings("cast")
@Test
public void testInt393() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((int) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (int) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (int) 3).append("b", (int) 4).toString()); 
 }
@Test
public void testIntArray394() { 
     int[] array = new int[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testShort395() { 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append((short) 3).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", (short) 3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", (short) 3).append("b", (short) 4).toString()); 
 }
@Test
public void testShortArray396() { 
     short[] array = new short[] { 1, 2, -3, 4 }; 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{1,2,-3,4}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testObject397() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).toString()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).toString()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).toString()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).toString()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).toString()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).toString()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).toString()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).toString()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).toString()); 
 }
@Test
public void testAppendSuper398() { 
     assertEquals(baseStr + "[]", new ToStringBuilder(base).appendSuper("Integer@8888[]").toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[<null>,a=hello]", new ToStringBuilder(base).appendSuper("Integer@8888[<null>]").append("a", "hello").toString()); 
     assertEquals(baseStr + "[a=hello]", new ToStringBuilder(base).appendSuper(null).append("a", "hello").toString()); 
 }
@Test
public void testObjectBuild399() { 
     final Integer i3 = Integer.valueOf(3); 
     final Integer i4 = Integer.valueOf(4); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) null).build()); 
     assertEquals(baseStr + "[3]", new ToStringBuilder(base).append(i3).build()); 
     assertEquals(baseStr + "[a=<null>]", new ToStringBuilder(base).append("a", (Object) null).build()); 
     assertEquals(baseStr + "[a=3]", new ToStringBuilder(base).append("a", i3).build()); 
     assertEquals(baseStr + "[a=3,b=4]", new ToStringBuilder(base).append("a", i3).append("b", i4).build()); 
     assertEquals(baseStr + "[a=<Integer>]", new ToStringBuilder(base).append("a", i3, false).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), false).build()); 
     assertEquals(baseStr + "[a=[]]", new ToStringBuilder(base).append("a", new ArrayList<Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", new HashMap<Object, Object>(), true).build()); 
     assertEquals(baseStr + "[a=<size=0>]", new ToStringBuilder(base).append("a", (Object) new String[0], false).build()); 
     assertEquals(baseStr + "[a={}]", new ToStringBuilder(base).append("a", (Object) new String[0], true).build()); 
 }
@Test
public void testSelfInstanceTwoVarsReflectionObjectCycle828() throws Exception { 
     final SelfInstanceTwoVarsReflectionTestFixture test = new SelfInstanceTwoVarsReflectionTestFixture(); 
     assertEquals(this.toBaseString(test) + "[typeIsSelf=" + this.toBaseString(test) + ",otherType=" + test.getOtherType().toString() + "]", test.toString()); 
 }
@Test
public void testInheritedReflectionStatics829() { 
     final InheritedReflectionStaticFieldsFixture instance1 = new InheritedReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, InheritedReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", ReflectionToStringBuilder.toString(instance1, null, false, true, SimpleReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", this.toStringWithStatics(instance1, null, SimpleReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", this.toStringWithStatics(instance1, null, SimpleReflectionStaticFieldsFixture.class)); 
 }
@Test
public void testReflectionStatics835() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid836() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 }
@Test
public void testReflectionByteArrayArray837() { 
     byte[][] array = new byte[][] { { 1, 2 }, null, { 5 } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 }
@Test
public void testReflectionNull838() { 
     assertEquals("<null>", ReflectionToStringBuilder.toString(null)); 
 }
@Test
public void testSimpleReflectionObjectCycle1109() throws Exception { 
     final SimpleReflectionTestFixture simple = new SimpleReflectionTestFixture(); 
     simple.o = simple; 
     assertEquals(this.toBaseString(simple) + "[o=" + this.toBaseString(simple) + "]", simple.toString()); 
 }
@Test
public void testDoubleArrayArray1112() { 
     double[][] array = new double[][] { { 1.0, 2.29686 }, null, { Double.NaN } }; 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
@Test
public void testReflectionLongArrayArray1114() { 
     long[][] array = new long[][] { { 1, 2 }, null, { 5 } }; 
     final String baseStr = this.toBaseString(array); 
     assertEquals(baseStr + "[{{1,2},<null>,{5}}]", ToStringBuilder.reflectionToString(array)); 
     array = null; 
     assertReflectionArray("<null>", array); 
 }
    

    

    

    

    

    

    /**
     * Test wrapper for int primitive.
     */
    

    /**
     * Test wrapper for char primitive.
     */
    

    /**
     * Test wrapper for char boolean.
     */
    

    /**
     * Create the same toString() as Object.toString().
     * @param o the object to create the string for.
     * @return a String in the Object.toString format.
     */
    private String toBaseString(final Object o) {
        return o.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(o));
    }

    // Reflection Array tests

    //
    // Note on the following line of code repeated in the reflection array tests.
    //
    // assertReflectionArray("<null>", array);
    //
    // The expected value is not baseStr + "[<null>]" since array==null and is typed as Object.
    // The null array does not carry array type information.
    // If we added a primitive array type constructor and pile of associated methods,
    // then type declaring type information could be carried forward. IMHO, null is null.
    //
    // Gary Gregory - 2003-03-12 - ggregory@seagullsw.com
    //

    public void assertReflectionArray(final String expected, final Object actual) {
        if (actual == null) {
            // Until ToStringBuilder supports null objects.
            return;
        }
        assertEquals(expected, ToStringBuilder.reflectionToString(actual));
        assertEquals(expected, ToStringBuilder.reflectionToString(actual, null));
        assertEquals(expected, ToStringBuilder.reflectionToString(actual, null, true));
        assertEquals(expected, ToStringBuilder.reflectionToString(actual, null, false));
    }

    

    

    

    

    

    

    

    

    

    // Reflection Array Array tests

    


    

    

    

    

    

    

    

    // Reflection hierarchy tests
    
// Defects4J: flaky method
//     @Test
//     public void testReflectionHierarchyArrayList() {
//         final List<Object> base = new ArrayList<Object>();
//         final String baseStr = this.toBaseString(base);
//         // note, the test data depends on the internal representation of the ArrayList, which may differ between JDK versions and vendors
//         final String expectedWithTransients = baseStr + "[elementData={<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>},size=0,modCount=0]";
//         final String toStringWithTransients = ToStringBuilder.reflectionToString(base, null, true);
//         if (!expectedWithTransients.equals(toStringWithTransients)) {
//             // representation different for IBM JDK 1.6.0, LANG-727
//             if (!("IBM Corporation".equals(SystemUtils.JAVA_VENDOR) && "1.6".equals(SystemUtils.JAVA_SPECIFICATION_VERSION))) {
//                 assertEquals(expectedWithTransients, toStringWithTransients);
//             }
//         }
//         final String expectedWithoutTransients = baseStr + "[size=0]";
//         final String toStringWithoutTransients = ToStringBuilder.reflectionToString(base, null, false);
//         if (!expectedWithoutTransients.equals(toStringWithoutTransients)) {
//             // representation different for IBM JDK 1.6.0, LANG-727
//             if (!("IBM Corporation".equals(SystemUtils.JAVA_VENDOR) && "1.6".equals(SystemUtils.JAVA_SPECIFICATION_VERSION))) {
//                 assertEquals(expectedWithoutTransients, toStringWithoutTransients);
//             }
//         }
//     }

    

    static class ReflectionTestFixtureA {
        @SuppressWarnings("unused")
        private final char a='a';
        @SuppressWarnings("unused")
        private transient char transientA='t';
    }

    static class ReflectionTestFixtureB extends ReflectionTestFixtureA {
        @SuppressWarnings("unused")
        private final char b='b';
        @SuppressWarnings("unused")
        private transient char transientB='t';
    }

    

    static class Outer {
        Inner inner = new Inner();
        class Inner {
            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }
        }
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    // Reflection cycle tests

    /**
     * Test an array element pointing to its container.
     */
    

    /**
     * Test an array element pointing to its container.
     */
    

    

    /**
     * A reflection test fixture.
     */
    static class ReflectionTestCycleA {
        ReflectionTestCycleB b;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    /**
     * A reflection test fixture.
     */
    static class ReflectionTestCycleB {
        ReflectionTestCycleA a;

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    /**
     * A reflection test fixture.
     */
    static class SimpleReflectionTestFixture {
        Object o;

        public SimpleReflectionTestFixture() {
        }

        public SimpleReflectionTestFixture(final Object o) {
            this.o = o;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    }

    private static class SelfInstanceVarReflectionTestFixture {
        @SuppressWarnings("unused")
        private final SelfInstanceVarReflectionTestFixture typeIsSelf;

        public SelfInstanceVarReflectionTestFixture() {
            this.typeIsSelf = this;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
      }

    private static class SelfInstanceTwoVarsReflectionTestFixture {
        @SuppressWarnings("unused")
        private final SelfInstanceTwoVarsReflectionTestFixture typeIsSelf;
        private final String otherType = "The Other Type";

        public SelfInstanceTwoVarsReflectionTestFixture() {
            this.typeIsSelf = this;
        }

        public String getOtherType(){
            return this.otherType;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
      }


    /**
     * Test an Object pointing to itself, the simplest test.
     *
     * @throws Exception
     */
    

    /**
     * Test a class that defines an ivar pointing to itself.
     *
     * @throws Exception
     */
    

    /**
     * Test a class that defines an ivar pointing to itself.  This test was
     * created to show that handling cyclical object resulted in a missing endFieldSeparator call.
     *
     * @throws Exception
     */
    


    /**
     * Test Objects pointing to each other.
     *
     * @throws Exception
     */
    

    /**
     * Test a nasty combination of arrays and Objects pointing to each other.
     * objects[0] -> SimpleReflectionTestFixture[ o -> objects ]
     *
     * @throws Exception
     */
    

    void validateNullToStringStyleRegistry() {
        final Map<Object, Object> registry = ToStringStyle.getRegistry();
        assertNull("Expected null, actual: "+registry, registry);
    }
    //  End: Reflection cycle tests

    

    

    
    
    

    

    

    

    

    

    

    

    


    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    static class ObjectCycle {
        Object obj;

        @Override
        public String toString() {
            return new ToStringBuilder(this).append(obj).toString();
        }
    }

    

    /**
     * Tests ReflectionToStringBuilder.toString() for statics.
     */
    

    /**
     * Tests ReflectionToStringBuilder.toString() for statics.
     */
    

    /**
     * <p>This method uses reflection to build a suitable
     * <code>toString</code> value which includes static fields.</p>
     *
     * <p>It uses <code>AccessibleObject.setAccessible</code> to gain access to private
     * fields. This means that it will throw a security exception if run
     * under a security manager, if the permissions are not set up correctly.
     * It is also not as efficient as testing explicitly. </p>
     *
     * <p>Transient fields are not output.</p>
     *
     * <p>Superclass fields will be appended up to and including the specified superclass.
     * A null superclass is treated as <code>java.lang.Object</code>.</p>
     *
     * <p>If the style is <code>null</code>, the default
     * <code>ToStringStyle</code> is used.</p>
     *
     * @param object  the Object to be output
     * @param style  the style of the <code>toString</code> to create,
     *  may be <code>null</code>
     * @param reflectUpToClass  the superclass to reflect up to (inclusive),
     *  may be <code>null</code>
     * @return the String result
     * @throws IllegalArgumentException if the Object is <code>null</code>
     */
    public <T> String toStringWithStatics(final T object, final ToStringStyle style, final Class<? super T> reflectUpToClass) {
        return ReflectionToStringBuilder.toString(object, style, false, true, reflectUpToClass);
    }

    /**
     * Tests ReflectionToStringBuilder setUpToClass().
     */
    

    /**
     * Tests ReflectionToStringBuilder setUpToClass().
     */
    

    /**
     * Tests ReflectionToStringBuilder.toString() for statics.
     */
    class ReflectionStaticFieldsFixture {
        static final String staticString = "staticString";
        static final int staticInt = 12345;
        static final transient String staticTransientString = "staticTransientString";
        static final transient int staticTransientInt = 54321;
        String instanceString = "instanceString";
        int instanceInt = 67890;
        transient String transientString = "transientString";
        transient int transientInt = 98765;
    }

    /**
     * Test fixture for ReflectionToStringBuilder.toString() for statics.
     */
    class SimpleReflectionStaticFieldsFixture {
        static final String staticString = "staticString";
        static final int staticInt = 12345;
    }

    /**
     * Test fixture for ReflectionToStringBuilder.toString() for statics.
     */
    class InheritedReflectionStaticFieldsFixture extends SimpleReflectionStaticFieldsFixture {
        static final String staticString2 = "staticString2";
        static final int staticInt2 = 67890;
    }

    

    /**
     * Points out failure to print anything from appendToString methods using MULTI_LINE_STYLE.
     * See issue LANG-372.
     */
    class MultiLineTestObject {
        Integer i = Integer.valueOf(31337);
        @Override
        public String toString() {
            return new ToStringBuilder(this).append("testInt", i).toString();
        }
    }

    

}
