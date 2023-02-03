/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2009, by Object Refinery Limited and Contributors.
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
 * -------------------------------
 * BoxAndWhiskerRendererTests.java
 * -------------------------------
 * (C) Copyright 2003-2009, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 22-Oct-2003 : Version 1 (DG);
 * 23-Apr-2004 : Extended testEquals() method (DG);
 * 12-Oct-2006 : Added new checks for bug 1572478 (DG);
 * 11-May-2007 : Added testGetLegendItem() (DG);
 * 17-May-2007 : Added testGetLegendItemSeriesIndex() (DG);
 * 08-Oct-2007 : Added tests for null items in dataset (DG);
 * 15-Jan-2008 : Updated testEquals() (DG);
 * 23-Apr-2008 : Added testPublicCloneable() (DG);
 * 21-Jan-2009 : Updated testEquals() for new fields (DG);
 *
 */

package org.jfree.chart.renderer.category.junit;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.chart.BufferedImageRenderingSource;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.util.PublicCloneable;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

/**
 * Tests for the {@link BoxAndWhiskerRenderer} class.
 */
public class BoxAndWhiskerRendererTests extends TestCase {

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(BoxAndWhiskerRendererTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public BoxAndWhiskerRendererTests(String name) {
        super(name);
    }

    /**
     * Test that the equals() method distinguishes all fields.
     */
public void testBoxAndWhiskerRenderer1083() { BoxAndWhiskerRenderer r = new BoxAndWhiskerRenderer(); }
public void testDrawVerticalItem1110() { }
public void testSetSeriesKey5825() { LegendItem item1 = new LegendItem("Label 1"); LegendItem item2 = new LegendItem("Label 2"); item1.setSeriesKey("A"); item2.setSeriesKey("B"); assertEquals("A", item1.getSeriesKey()); assertEquals("B", item2.getSeriesKey()); }
public void testSetSeriesKey5826() { LegendItem item1 = new LegendItem("Label1"); item1.setSeriesKey("A"); assertEquals("A", item1.getSeriesKey()); LegendItem item2 = new LegendItem("Label2"); item2.setSeriesKey("B"); assertEquals("B", item2.getSeriesKey()); LegendItem item3 = new LegendItem("Label3"); item3.setSeriesKey("A"); assertEquals("A", item3.getSeriesKey()); }
public void testGetSeriesIndex5827() { LegendItem item1 = new LegendItem("Label1"); LegendItem item2 = new LegendItem("Label2"); LegendItem item3 = new LegendItem("Label3"); item1.setSeriesIndex(0); item2.setSeriesIndex(1); assertEquals(0, item1.getSeriesIndex()); assertEquals(1, item2.getSeriesIndex()); assertEquals(2, item3.getSeriesIndex()); }
public void testConstructor5828() { LegendItem item1 = new LegendItem("Label 1"); LegendItem item2 = new LegendItem("Label 2"); LegendItem item3 = new LegendItem("Label 3"); LegendItem item4 = new LegendItem("Label 4"); assertEquals(0, item1.getSeriesIndex()); assertEquals(0, item2.getSeriesIndex()); assertEquals(0, item3.getSeriesIndex()); assertEquals(0, item4.getSeriesIndex()); }
public void testSetSeriesIndex5829() { LegendItem item1 = new LegendItem("Label1"); LegendItem item2 = new LegendItem("Label2"); item1.setSeriesIndex(0); assertEquals(0, item1.getSeriesIndex()); item1.setSeriesIndex(1); assertEquals(1, item1.getSeriesIndex()); item2.setSeriesIndex(2); assertEquals(2, item2.getSeriesIndex()); }
public void testConstructor5830() { LegendItem item1 = new LegendItem("Label1"); LegendItem item2 = new LegendItem("Label2"); assertEquals(0, item1.getSeriesIndex()); assertEquals(0, item2.getSeriesIndex()); item1.setSeriesIndex(1); assertEquals(1, item1.getSeriesIndex()); assertEquals(1, item2.getSeriesIndex()); item2.setSeriesIndex(2); assertEquals(2, item1.getSeriesIndex()); assertEquals(2, item2.getSeriesIndex()); }
public void testGetLabel5831() { LegendItem item1 = new LegendItem("Label 1"); LegendItem item2 = new LegendItem("Label 2"); LegendItem item3 = new LegendItem("Label 3"); LegendItem item4 = new LegendItem("Label 4"); assertEquals("Label 1", item1.getLabel()); assertEquals("Label 2", item2.getLabel()); assertEquals("Label 3", item3.getLabel()); assertEquals("Label 4", item4.getLabel()); }
public void testGetLabel5832() { LegendItem item1 = new LegendItem("Label 1"); LegendItem item2 = new LegendItem("Label 2"); LegendItem item3 = new LegendItem("Label 3"); assertEquals("Label 1", item1.getLabel()); assertEquals("Label 2", item2.getLabel()); assertEquals("Label 3", item3.getLabel()); }
    

    /**
     * Two objects that are equal are required to return the same hashCode.
     */
    

    /**
     * Confirm that cloning works.
     */
    

    /**
     * Check that this class implements PublicCloneable.
     */
    

    /**
     * Serialize an instance, restore it, and check for equality.
     */
    

    /**
     * Draws the chart with a <code>null</code> info object to make sure that
     * no exceptions are thrown (particularly by code in the renderer).
     */
    

    /**
     * A check for bug 1572478 (for the vertical orientation).
     */
    

    /**
     * A check for bug 1572478 (for the horizontal orientation).
     */
    

    /**
     * Some checks for the getLegendItem() method.
     */
    

    /**
     * A check for the datasetIndex and seriesIndex fields in the LegendItem
     * returned by the getLegendItem() method.
     */
    

    /**
     * Draws a chart where the dataset contains a null mean value.
     */
    

    /**
     * Draws a chart where the dataset contains a null median value.
     */
    

    /**
     * Draws a chart where the dataset contains a null Q1 value.
     */
    

    /**
     * Draws a chart where the dataset contains a null Q3 value.
     */
    

    /**
     * Draws a chart where the dataset contains a null min regular value.
     */
    

    /**
     * Draws a chart where the dataset contains a null max regular value.
     */
    

    /**
     * Draws a chart where the dataset contains a null min outlier value.
     */
    

    /**
     * Draws a chart where the dataset contains a null max outlier value.
     */
    

}
