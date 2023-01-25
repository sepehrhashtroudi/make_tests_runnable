/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2008, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ---------------
 * RangeTests.java
 * ---------------
 * (C) Copyright 2003-2008, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Sergei Ivanov;
 *
 * Changes
 * -------
 * 14-Aug-2003 : Version 1 (DG);
 * 18-Dec-2007 : Additional tests from Sergei Ivanov (DG);
 *
 */

package org.jfree.data.junit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.data.Range;

/**
 * Tests for the {@link Range} class.
 */
public class RangeTests extends TestCase {

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(RangeTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public RangeTests(String name) {
        super(name);
    }

    /**
     * Confirm that the constructor initializes all the required fields.
     */
public void testEquals1470() { 
     Range r1 = new Range(0.0, 100.0); 
     Range r2 = new Range(0.0, 100.0); 
     assertTrue(r1.equals(r2)); 
     assertTrue(r2.equals(r1)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.equals(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.equals(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.equals(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.equals(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.equals(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.equals(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.equals(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.equals(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.equals(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.equals(r2)); 
 }
public void testIntersects1473() { 
     Range r1 = new Range(0.0, 100.0); 
     Range r2 = new Range(0.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
     assertTrue(r2.intersects(r1)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-50.0, 100.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-50.0, 100.0); 
     assertTrue(r1.intersects(r2)); 
 }
public void testIntersects1474() { 
     Range r1 = new Range(-10.0, 20.0); 
     Range r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     assertTrue(r2.intersects(r1)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
     r1 = new Range(-10.0, 20.0); 
     assertFalse(r1.intersects(r2)); 
     r2 = new Range(-10.0, 20.0); 
     assertTrue(r1.intersects(r2)); 
 }
    

    /**
     * Confirm that the equals method can distinguish all the required fields.
     */
    

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    

    /**
     * Simple tests for the contains() method.
     */
    

    /**
     * Tests the constrain() method for various values.
     */
    

    /**
     * Simple tests for the intersects() method.
     */
    

    /**
     * A simple test for the expand() method.
     */
    

    /**
     * A simple test for the scale() method.
     */
    

    /**
     * A simple test for the scale() method.
     */
    

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    

}
