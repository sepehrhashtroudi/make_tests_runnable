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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

/**
 * @version $Id$
 */
public class ReflectionToStringBuilderExcludeTest {

    class TestFixture {
        @SuppressWarnings("unused")
        private final String secretField = SECRET_VALUE;

        @SuppressWarnings("unused")
        private final String showField = NOT_SECRET_VALUE;
    }

    private static final String NOT_SECRET_FIELD = "showField";

    private static final String NOT_SECRET_VALUE = "Hello World!";

    private static final String SECRET_FIELD = "secretField";

    private static final String SECRET_VALUE = "secret value";

@Test
public void test_setExcludeFieldNames37() { 
     final String toString = ReflectionToStringBuilder.toString(new TestFixture(), new String[] { null }); 
     this.validateSecretFieldPresent(toString); 
 }
@Test
public void testSelfInstanceTwoVarsReflectionObjectCycle246() throws Exception { 
     final SelfInstanceTwoVarsReflectionTestFixture test = new SelfInstanceTwoVarsReflectionTestFixture(); 
     assertEquals(this.toBaseString(test) + "[typeIsSelf=" + this.toBaseString(test) + ",otherType=" + test.getOtherType().toString() + "]", test.toString()); 
 }
@Test
public void testInheritedReflectionStatics247() { 
     final InheritedReflectionStaticFieldsFixture instance1 = new InheritedReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, InheritedReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", ReflectionToStringBuilder.toString(instance1, null, false, true, SimpleReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", this.toStringWithStatics(instance1, null, SimpleReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString2=staticString2,staticInt2=67890,staticString=staticString,staticInt=12345]", this.toStringWithStatics(instance1, null, SimpleReflectionStaticFieldsFixture.class)); 
 }
@Test
public void test_toStringExcludeArrayWithNull248() { 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), new String[] { null }); 
     this.validateSecretFieldPresent(toString); 
 }
@Test
public void testReflectionHierarchy249() { 
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
     assertEquals(baseStr + "[b=b,a=a]", ToStringBuilder.reflectionToString(baseB, null, false, null)); [EOL
@Test
public void testReflectionStatics250() { 
     final ReflectionStaticFieldsFixture instance1 = new ReflectionStaticFieldsFixture(); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", ReflectionToStringBuilder.toString(instance1, null, false, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,staticTransientString=staticTransientString,staticTransientInt=54321,instanceString=instanceString,instanceInt=67890,transientString=transientString,transientInt=98765]", ReflectionToStringBuilder.toString(instance1, null, true, true, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
     assertEquals(this.toBaseString(instance1) + "[staticString=staticString,staticInt=12345,instanceString=instanceString,instanceInt=67890]", this.toStringWithStatics(instance1, null, ReflectionStaticFieldsFixture.class)); 
 }
@Test
public void test_toStringExcludeCollectionWithNulls251() { 
     final List<String> excludeList = new ArrayList<String>(); 
     excludeList.add(null); 
     excludeList.add(null); 
     final String toString = ReflectionToStringBuilder.toStringExclude(new TestFixture(), excludeList); 
     this.validateSecretFieldPresent(toString); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_setUpToClass_invalid252() { 
     final Integer val = Integer.valueOf(5); 
     final ReflectionToStringBuilder test = new ReflectionToStringBuilder(val); 
     try { 
         test.setUpToClass(String.class); 
     } finally { 
         test.toString(); 
     } 
 }
@Test
public void testFloatArrayArray503() { 
     float[][] array = new float[][] { { 1.0f, 2.29686f }, null, { Float.NaN } }; 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[{{1.0,2.29686},<null>,{NaN}}]", new ToStringBuilder(base).append((Object) array).toString()); 
     array = null; 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append(array).toString()); 
     assertEquals(baseStr + "[<null>]", new ToStringBuilder(base).append((Object) array).toString()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    private void validateNonSecretField(final String toString) {
        Assert.assertTrue(toString.indexOf(NOT_SECRET_FIELD) > ArrayUtils.INDEX_NOT_FOUND);
        Assert.assertTrue(toString.indexOf(NOT_SECRET_VALUE) > ArrayUtils.INDEX_NOT_FOUND);
    }

    private void validateSecretFieldAbsent(final String toString) {
        Assert.assertEquals(ArrayUtils.INDEX_NOT_FOUND, toString.indexOf(SECRET_VALUE));
        this.validateNonSecretField(toString);
    }

    private void validateSecretFieldPresent(final String toString) {
        Assert.assertTrue(toString.indexOf(SECRET_VALUE) > 0);
        this.validateNonSecretField(toString);
    }
}
