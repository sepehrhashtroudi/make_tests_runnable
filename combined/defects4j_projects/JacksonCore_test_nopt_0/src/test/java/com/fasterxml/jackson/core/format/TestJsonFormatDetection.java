package com.fasterxml.jackson.core.format;

import java.io.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.DataFormatDetector;
import com.fasterxml.jackson.core.format.DataFormatMatcher;
import com.fasterxml.jackson.core.format.MatchStrength;

public class TestJsonFormatDetection extends com.fasterxml.jackson.test.BaseTest
{
public void testGetFormatName503() { JsonFactory f = new JsonFactory() { @Override public String getFormatName() { return "JSON"; } }; assertEquals("JSON", f.getFormatName()); f = new JsonFactory() { @Override public String getFormatName() { return null; } }; assertNull(f.getFormatName()); f = new JsonFactory() { @Override public String getFormatName() { return "JSON"; } }; assertEquals("JSON", f.getFormatName()); f = new JsonFactory() { @Override public String getFormatName() { return null; } }; assertEquals("JSON", f.getFormatName()); }
public void testGetFormatName504() { JsonFactory f = new JsonFactory() { @Override public String getFormatName() { return "json"; } }; assertEquals("json", f.getFormatName()); }
public void testGetFormatName505() { JsonFactory f = new JsonFactory(); assertEquals(JsonFactory.FORMAT_NAME_JSON, f.getFormatName()); }
    

    

    /**
     * While JSON String is not a strong match alone, it should
     * be detected unless some better match is available
     */
    
    
    

}
