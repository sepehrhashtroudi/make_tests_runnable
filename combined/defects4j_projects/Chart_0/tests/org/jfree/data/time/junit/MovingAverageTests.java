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
 * -----------------------
 * MovingAverageTests.java
 * -----------------------
 * (C) Copyright 2003-2009, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 14-Aug-2003 : Version 1 (DG);
 * 04-Oct-2004 : Eliminated NumberUtils usage (DG);
 * 21-Jun-2007 : Removed JCommon dependencies (DG);
 *
 */

package org.jfree.data.time.junit;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.jfree.data.time.Day;
import org.jfree.data.time.MonthConstants;
import org.jfree.data.time.MovingAverage;
import org.jfree.data.time.TimeSeries;

/**
 * Tests for the {@link MovingAverage} class.
 */
public class MovingAverageTests extends TestCase {

    private static final double EPSILON = 0.0000000001;

    /**
     * Returns the tests as a test suite.
     *
     * @return The test suite.
     */
    public static Test suite() {
        return new TestSuite(MovingAverageTests.class);
    }

    /**
     * Constructs a new set of tests.
     *
     * @param name  the name of the tests.
     */
    public MovingAverageTests(String name) {
        super(name);
    }

    /**
     * A test for the values calculated from a time series.
     */
    

    /**
     * Creates a sample series.
     *
     * @return A sample series.
     */
    private TimeSeries createDailyTimeSeries1() {

        TimeSeries series = new TimeSeries("Series 1");
        series.add(new Day(11, MonthConstants.AUGUST, 2003), 11.2);
        series.add(new Day(13, MonthConstants.AUGUST, 2003), 13.8);
        series.add(new Day(17, MonthConstants.AUGUST, 2003), 14.1);
        series.add(new Day(18, MonthConstants.AUGUST, 2003), 12.7);
        series.add(new Day(19, MonthConstants.AUGUST, 2003), 16.5);
        series.add(new Day(20, MonthConstants.AUGUST, 2003), 15.6);
        series.add(new Day(25, MonthConstants.AUGUST, 2003), 19.8);
        series.add(new Day(27, MonthConstants.AUGUST, 2003), 10.7);
        series.add(new Day(28, MonthConstants.AUGUST, 2003), 14.3);
        return series;

    }

}
