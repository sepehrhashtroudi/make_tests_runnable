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
 * --------------------------------------
 * StandardXYItemLabelGeneratorTests.java
 * --------------------------------------
 * (C) Copyright 2003-2008, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 23-Mar-2003 : Version 1 (DG);
 * 26-Feb-2004 : Updates for new code (DG);
 * 20-Jan-2006 : Renamed StandardXYItemLabelGeneratorTests.java (DG);
 * 25-Jan-2007 : Added independence checks to testCloning() (DG);
 * 23-Apr-2008 : Added testPublicCloneable() (DG);
 *
 */

package org.jfree.chart.labels.junit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.util.PublicCloneable;

/**
 * Tests for the {@link StandardXYItemLabelGenerator} class.
 */
public class StandardXYItemLabelGeneratorTests extends TestCase {

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(StandardXYItemLabelGeneratorTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public StandardXYItemLabelGeneratorTests(String name) {
        super(name);
    }

    /**
     * A series of tests for the equals() method.
     */
public void testGetXFormat795() { }
public void testGetXDateFormat797() { DateFormat xFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"); DateFormat xFormat1 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"); DateFormat xFormat2 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"); DateFormat xFormat3 = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'"); DateFormat yFormat = new SimpleDateFormat("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'");
}

public void testGetYFormat799() { }
public void testGetYDateFormat800() { }
public void testClone7428() throws CloneNotSupportedException { StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator(); StandardXYItemLabelGenerator g2 = (StandardXYItemLabelGenerator) g1.clone(); assertEquals(g1, g2); }
public void testCloning7429() throws CloneNotSupportedException { StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator(); StandardXYItemLabelGenerator g2 = (StandardXYItemLabelGenerator) g1.clone(); assertNotSame(g1, g2); assertSame(g1.getClass(), g2.getClass()); assertEquals(g1, g2); }
public void testEquals7431() { StandardXYItemLabelGenerator g1 = new StandardXYItemLabelGenerator(); StandardXYItemLabelGenerator g2 = new StandardXYItemLabelGenerator(); assertEquals(g1, g2); }
    

    /**
     * Simple check that hashCode is implemented.
     */
    

    /**
     * Confirm that cloning works.
     */
    

    /**
     * Check to ensure that this class implements PublicCloneable.
     */
    

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    

}
