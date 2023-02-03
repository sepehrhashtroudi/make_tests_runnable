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
 * --------------------
 * ColorBlockTests.java
 * --------------------
 * (C) Copyright 2007, 2008, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 16-Mar-2007 : Version 1 (DG);
 *
 */

package org.jfree.chart.block.junit;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.chart.block.ColorBlock;

/**
 * Tests for the {@link ColorBlock} class.
 */
public class ColorBlockTests extends TestCase {

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(ColorBlockTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public ColorBlockTests(String name) {
        super(name);
    }

    /**
     * Confirm that the equals() method can distinguish all the required fields.
     */
public void testColorBlock6883() { ColorBlock cm = new ColorBlock(Color.RED, 10.0, 20.0); assertEquals(Color.RED, cm.getPaint()); assertEquals(10.0, cm.getWidth(), 0.0); assertEquals(20.0, cm.getHeight(), 0.0); cm = new ColorBlock(Color.BLUE, 10.0, 20.0); assertEquals(Color.BLUE, cm.getPaint()); assertEquals(10.0, cm.getWidth(), 0.0); assertEquals(20.0, cm.getHeight(), 0.0); }
public void testCloning6885() throws CloneNotSupportedException { ColorBlock cm1 = new ColorBlock(Color.RED, 10.0, 20.0); ColorBlock cm2 = (ColorBlock) cm1.clone(); assertNotSame(cm1, cm2); assertSame(cm1.getPaint(), cm2.getPaint()); assertEquals(cm1.getWidth(), cm2.getWidth(), 0.01); assertEquals(cm1.getHeight(), cm2.getHeight(), 0.01); }
public void testEquals6888() { ColorBlock b1 = new ColorBlock(Color.RED, 1.0, 2.0); ColorBlock b2 = new ColorBlock(Color.RED, 1.0, 2.0); assertEquals(b1, b2); assertEquals(b2, b2); b1 = new ColorBlock(Color.BLUE, 1.0, 2.0); assertFalse(b1.equals(b2)); b2 = new ColorBlock(Color.BLUE, 1.0, 2.0); assertEquals(b1, b2); b1 = new ColorBlock(Color.BLUE, 1.0, 2.0);
}

    

    /**
     * Confirm that cloning works.
     */
    

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    

}