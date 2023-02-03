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
 * ----------------------------------------
 * MultipleXYSeriesLabelGeneratorTests.java
 * ----------------------------------------
 * (C) Copyright 2007, 2008, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 20-Jan-2007 : Version 1 (DG);
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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.chart.labels.MultipleXYSeriesLabelGenerator;
import org.jfree.chart.util.PublicCloneable;

/**
 * Tests for the {@link MultipleXYSeriesLabelGenerator} class.
 */
public class MultipleXYSeriesLabelGeneratorTests extends TestCase {

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(MultipleXYSeriesLabelGeneratorTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public MultipleXYSeriesLabelGeneratorTests(String name) {
        super(name);
    }

    /**
     * A series of tests for the equals() method.
     */
public void testEquals5050() { MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator(); g1.addSeriesLabel(0, "Series 1"); g1.addSeriesLabel(1, "Series 2"); g1.addSeriesLabel(2, "Series 3"); MultipleXYSeriesLabelGenerator g2 = new MultipleXYSeriesLabelGenerator(); g2.addSeriesLabel(0, "Series 1"); g2.addSeriesLabel(1, "Series 2"); g2.addSeriesLabel(2, "Series 3"); assertEquals(g1, g2); }
public void testHashCode5051() { MultipleXYSeriesLabelGenerator g1 = new MultipleXYSeriesLabelGenerator(); MultipleXYSeriesLabelGenerator g2 = new MultipleXYSeriesLabelGenerator(); assertEquals(g1.hashCode(), g2.hashCode()); }
    

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