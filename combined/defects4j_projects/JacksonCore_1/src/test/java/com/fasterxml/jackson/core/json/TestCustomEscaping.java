package com.fasterxml.jackson.core.json;

import java.io.*;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;

public class TestCustomEscaping extends com.fasterxml.jackson.test.BaseTest
{
    final static int TWO_BYTE_ESCAPED = 0x111;
    final static int THREE_BYTE_ESCAPED = 0x1111;

    final static SerializedString TWO_BYTE_ESCAPED_STRING = new SerializedString("&111;");
    final static SerializedString THREE_BYTE_ESCAPED_STRING = new SerializedString("&1111;");
    
    /*
    /********************************************************
    /* Helper types
    /********************************************************
     */

    /**
     * Trivial simple custom escape definition set.
     */
    @SuppressWarnings("serial")
    static class MyEscapes extends CharacterEscapes
    {
        
        private final int[] _asciiEscapes;

        public MyEscapes() {
            _asciiEscapes = standardAsciiEscapesForJSON();
            _asciiEscapes['a'] = 'A'; // to basically give us "\A"
            _asciiEscapes['b'] = CharacterEscapes.ESCAPE_STANDARD; // too force "\u0062"
            _asciiEscapes['d'] = CharacterEscapes.ESCAPE_CUSTOM;
        }
        
        @Override
        public int[] getEscapeCodesForAscii() {
            return _asciiEscapes;
        }

        @Override
        public SerializableString getEscapeSequence(int ch)
        {
            if (ch == 'd') {
                return new SerializedString("[D]");
            }
            if (ch == TWO_BYTE_ESCAPED) {
                return TWO_BYTE_ESCAPED_STRING;
            }
            if (ch == THREE_BYTE_ESCAPED) {
                return THREE_BYTE_ESCAPED_STRING;
            }
            return null;
        }
    }
    
    /*
    /********************************************************
    /* Unit tests
    /********************************************************
     */

    /**
     * Test to ensure that it is possible to force escaping
     * of non-ASCII characters.
     * Related to [JACKSON-102]
     */
public void testAboveAsciiEscapeWithUTF8Stream50() throws Exception { 
     _testEscapeAboveAscii(true); 
 }
public void testWriteCustomStringSegments59() throws Exception { 
     JsonFactory jf = new JsonFactory(); 
     String[] inputStrings = new String[] { "", "X", "1234567890" }; 
     for (int useReader = 0; useReader < 2; ++useReader) { 
         for (int writeString = 0; writeString < 2; ++writeString) { 
             for (int strIx = 0; strIx < inputStrings.length; ++strIx) { 
                 String input = inputStrings[strIx]; 
                 JsonGenerator gen; 
                 ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
                 if (useReader != 0) { 
                     gen = jf.createGenerator(new OutputStreamWriter(bout, "UTF-8")); 
                 } else { 
                     gen = jf.createGenerator(bout, JsonEncoding.UTF8); 
                 } 
                 if (writeString > 0) { 
                     gen.writeString(input); 
                 } else { 
                     int len = input.length(); 
                     char[] buffer = new char[len + 20]; 
                     input.getChars(0, len, buffer, strIx); 
                     gen.writeString(buffer, strIx, len); 
                 } 
                 gen.flush(); 
                 gen.close(); 
                 JsonParser jp = jf.createParser(new ByteArrayInputStream(bout.toByteArray())); 
                 JsonToken t = jp.nextToken(); 
                 assertNotNull("Document \"" + bout.toString("UTF-8") + "\" yielded no tokens", t); 
                 assertEquals(JsonToken.VALUE_STRING, t); 
                 assertEquals(input, jp.getText()); 
                 assertEquals(null, jp.nextToken()); 
                 jp.close(); 
             } 
         } 
     } 
 }
public void testEscapeCustomWithReader60() throws Exception { 
     _testEscapeCustom(false); 
 }
public void testCustomEscapes62() throws Exception { 
     JsonFactory jf = new JsonFactory(); 
     String[] inputStrings = new String[] { "", "X", "1234567890" }; 
     for (int useReader = 0; useReader < 2; ++useReader) { 
         for (int writeString = 0; writeString < 2; ++writeString) { 
             for (int strIx = 0; strIx < inputStrings.length; ++strIx) { 
                 String input = inputStrings[strIx]; 
                 JsonGenerator gen; 
                 ByteArrayOutputStream bout = new ByteArrayOutputStream(); 
                 if (useReader != 0) { 
                     gen = jf.createGenerator(new OutputStreamWriter(bout, "UTF-8")); 
                 } else { 
                     gen = jf.createGenerator(bout, JsonEncoding.UTF8); 
                 } 
                 if (writeString > 0) { 
                     gen.writeString(input); 
                 } else { 
                     int len = input.length(); 
                     char[] buffer = new char[len + 20]; 
                     input.getChars(0, len, buffer, strIx); 
                     gen.writeString(buffer, strIx, len); 
                 } 
                 gen.flush(); 
                 gen.close(); 
                 JsonParser jp = jf.createParser(new ByteArrayInputStream(bout.toByteArray())); 
                 JsonToken t = jp.nextToken(); 
                 assertNotNull("Document \"" + bout.toString("UTF-8") + "\" yielded no tokens", t); 
                 assertEquals(JsonToken.VALUE_STRING, t); 
                 assertEquals(input, jp.getText()); 
                 assertEquals(null, jp.nextToken()); 
                 jp.close(); 
             } 
         } 
     } 
 }
    

    

    // // // Tests for [JACKSON-106]
    
    

    
    
    /*
    /********************************************************
    /* Secondary test methods
    /********************************************************
     */

    @SuppressWarnings("resource")
    private void _testEscapeAboveAscii(boolean useStream) throws Exception
    {
        JsonFactory f = new JsonFactory();
        final String VALUE = "chars: [\u00A0]/[\u1234]";
        final String KEY = "fun:\u0088:\u3456";
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        JsonGenerator jgen;

        // First: output normally; should not add escaping
        if (useStream) {
            jgen = f.createGenerator(bytes, JsonEncoding.UTF8);
        } else {
            jgen = f.createGenerator(new OutputStreamWriter(bytes, "UTF-8"));
        }
        jgen.writeStartArray();
        jgen.writeString(VALUE);
        jgen.writeEndArray();
        jgen.close();
        String json = bytes.toString("UTF-8");
        
        assertEquals("["+quote(VALUE)+"]", json);

        // And then with forced ASCII; first, values

        bytes = new ByteArrayOutputStream();
        if (useStream) {
            jgen = f.createGenerator(bytes, JsonEncoding.UTF8);
        } else {
            jgen = f.createGenerator(new OutputStreamWriter(bytes, "UTF-8"));
        }
        jgen.enable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
        jgen.writeStartArray();
        jgen.writeString(VALUE);
        jgen.writeEndArray();
        jgen.close();
        json = bytes.toString("UTF-8");
        assertEquals("["+quote("chars: [\\u00A0]/[\\u1234]")+"]", json);

        // and then keys
        bytes = new ByteArrayOutputStream();
        if (useStream) {
            jgen = f.createGenerator(bytes, JsonEncoding.UTF8);
        } else {
            jgen = f.createGenerator(new OutputStreamWriter(bytes, "UTF-8"));
        }
        jgen.enable(JsonGenerator.Feature.ESCAPE_NON_ASCII);
        jgen.writeStartObject();
        jgen.writeFieldName(KEY);
        jgen.writeBoolean(true);
        jgen.writeEndObject();
        jgen.close();
        json = bytes.toString("UTF-8");
        assertEquals("{"+quote("fun:\\u0088:\\u3456")+":true}", json);
    }

    @SuppressWarnings("resource")
    private void _testEscapeCustom(boolean useStream) throws Exception
    {
        JsonFactory f = new JsonFactory().setCharacterEscapes(new MyEscapes());
        final String STR_IN = "[abcd/"+((char) TWO_BYTE_ESCAPED)+"/"+((char) THREE_BYTE_ESCAPED)+"]";
        final String STR_OUT = "[\\A\\u0062c[D]/"+TWO_BYTE_ESCAPED_STRING+"/"+THREE_BYTE_ESCAPED_STRING+"]";
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        JsonGenerator jgen;
        
        // First: output normally; should not add escaping
        if (useStream) {
            jgen = f.createGenerator(bytes, JsonEncoding.UTF8);
        } else {
            jgen = f.createGenerator(new OutputStreamWriter(bytes, "UTF-8"));
        }
        jgen.writeStartObject();
        jgen.writeStringField(STR_IN, STR_IN);
        jgen.writeEndObject();
        jgen.close();
        String json = bytes.toString("UTF-8");
        assertEquals("{"+quote(STR_OUT)+":"+quote(STR_OUT)+"}", json);
    }
}