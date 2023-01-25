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
public void testCloning1368() { 
     GradientPaint gp = new GradientPaint(1.0f, 2.0f, Color.red, 3.0f, 4.0f, Color.blue); 
     Rectangle2D bounds1 = new Rectangle2D.Double(10.0, 20.0, 30.0, 40.0); 
     ColorBlock b1 = new ColorBlock(gp, 1.0, 2.0); 
     b1.setBounds(bounds1); 
     ColorBlock b2 = null; 
     try { 
         b2 = (ColorBlock) b1.clone(); 
     } catch (CloneNotSupportedException e) { 
         e.printStackTrace(); 
     } 
     assertTrue(b1 != b2); 
     assertTrue(b1.getClass() == b2.getClass()); 
     assertTrue(b1.equals(b2)); 
     bounds1.setRect(1.0, 2.0, 3.0, 4.0); 
     assertFalse(b1.equals(b2)); 
     b2.setBounds(new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0)); 
     assertTrue(b1.equals(b2)); 
 }
    

    /**
     * Confirm that cloning works.
     */
    

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    

}