package com.fasterxml.jackson.core.main;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.*;

import com.fasterxml.jackson.core.*;

/**
 * Set of basic unit tests for verifying basic generator
 * features.
 */
public class TestGeneratorMisc
    extends com.fasterxml.jackson.test.BaseTest
{
    /*
    /**********************************************************
    /* Tests for closing, status
    /**********************************************************
     */

public void testIsClosed11() throws IOException { 
     JsonFactory jf = new JsonFactory(); 
     for (int i = 0; i < 2; ++i) { 
         boolean stream = ((i & 1) == 0); 
         JsonGenerator jg = stream ? jf.createGenerator(new StringWriter()) : jf.createGenerator(new ByteArrayOutputStream(), JsonEncoding.UTF8); 
         assertFalse(jg.isClosed()); 
         jg.writeStartArray(); 
         jg.writeNumber(-1); 
         jg.writeEndArray(); 
         assertFalse(jg.isClosed()); 
         jg.close(); 
         assertTrue(jg.isClosed()); 
         jg.close(); 
         assertTrue(jg.isClosed()); 
     } 
 }
public void testConvenienceMethodsWithNulls40() throws Exception { 
     StringWriter sw = new StringWriter(); 
     JsonGenerator gen = new JsonFactory().createGenerator(sw); 
     gen.writeStartObject(); 
     gen.writeStringField("str", null); 
     gen.writeNumberField("num", null); 
     gen.writeObjectField("obj", null); 
     gen.writeEndObject(); 
     gen.close(); 
     String docStr = sw.toString(); 
     JsonParser jp = createParserUsingReader(docStr); 
     assertEquals(JsonToken.START_OBJECT, jp.nextToken()); 
     assertEquals(JsonToken.FIELD_NAME, jp.nextToken()); 
     assertEquals("str", jp.getCurrentName()); 
     assertEquals(JsonToken.VALUE_NULL, jp.nextToken()); 
     assertEquals(JsonToken.FIELD_NAME, jp.nextToken()); 
     assertEquals("num", jp.getCurrentName()); 
     assertEquals(JsonToken.VALUE_NULL, jp.nextToken()); 
     assertEquals(JsonToken.FIELD_NAME, jp.nextToken()); 
     assertEquals("obj", jp.getCurrentName()); 
     assertEquals(JsonToken.VALUE_NULL, jp.nextToken()); 
     assertEquals(JsonToken.END_OBJECT, jp.nextToken()); 
     jp.close(); 
 }
public void testBigDecimalAsPlain44() throws IOException { 
     JsonFactory jf = new JsonFactory(); 
     BigDecimal ENG = new BigDecimal("1E+2"); 
     StringWriter sw = new StringWriter(); 
     JsonGenerator jg = jf.createGenerator(sw); 
     jg.writeNumber(ENG); 
     jg.close(); 
     assertEquals("1E+2", sw.toString()); 
     jf.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true); 
     sw = new StringWriter(); 
     jg = jf.createGenerator(sw); 
     jg.writeNumber(ENG); 
     jg.close(); 
     assertEquals("100", sw.toString()); 
 }
    

    // Also, "very simple" objects are supported even without Codec:
    
    
    /*
    /**********************************************************
    /* Tests for raw output
    /**********************************************************
     */

    

    
    
    /*
    /**********************************************************
    /* Tests for binary data
    /**********************************************************
     */

    /**
     * This is really inadequate test, all in all, but should serve
     * as some kind of sanity check. Reader-side should more thoroughly
     * test things, as it does need writers to construct the data first.
     */
    

    private void _testBinaryWrite(boolean useCharBased) throws Exception
    {
        /* The usual sample input string, from Thomas Hobbes's "Leviathan"
         * (via Wikipedia)
         */
        final String INPUT = "Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure.";
        final byte[] INPUT_BYTES = INPUT.getBytes("US-ASCII");
        // as per MIME variant, result minus lfs =
        final String OUTPUT =
 "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlz"
+"IHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2Yg"
+"dGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGlu"
+"dWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRo"
+"ZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4="
            ;

        /* Let's only test the standard base64 variant; but write
         * values in root, array and object contexts.
         */
        Base64Variant b64v = Base64Variants.getDefaultVariant();
        JsonFactory jf = new JsonFactory();

        for (int i = 0; i < 3; ++i) {
            JsonGenerator gen;
            ByteArrayOutputStream bout = new ByteArrayOutputStream(200);
            if (useCharBased) {
                gen = jf.createGenerator(new OutputStreamWriter(bout, "UTF-8"));
            } else {
                gen = jf.createGenerator(bout, JsonEncoding.UTF8);
            }

            switch (i) {
            case 0: // root
                gen.writeBinary(b64v, INPUT_BYTES, 0, INPUT_BYTES.length);
                break;
            case 1: // array
                gen.writeStartArray();
                gen.writeBinary(b64v, INPUT_BYTES, 0, INPUT_BYTES.length);
                gen.writeEndArray();
                break;
            default: // object
                gen.writeStartObject();
                gen.writeFieldName("field");
                gen.writeBinary(b64v, INPUT_BYTES, 0, INPUT_BYTES.length);
                gen.writeEndObject();
                break;
            }
            gen.close();

            JsonParser jp = jf.createParser(new ByteArrayInputStream(bout.toByteArray()));
            
            // Need to skip other events before binary data:
            switch (i) {
            case 0:
                break;
            case 1:
                assertEquals(JsonToken.START_ARRAY, jp.nextToken());
                break;
            default:
                assertEquals(JsonToken.START_OBJECT, jp.nextToken());
                assertEquals(JsonToken.FIELD_NAME, jp.nextToken());
                break;
            }
            assertEquals(JsonToken.VALUE_STRING, jp.nextToken());
            String actualValue = jp.getText();
            jp.close();
            assertEquals(OUTPUT, actualValue);
        }
    }

    /*
    /**********************************************************
    /* Tests for object writing
    /**********************************************************
     */

    /**
     * Unit test that tries to trigger buffer-boundary conditions
     */
    
}
