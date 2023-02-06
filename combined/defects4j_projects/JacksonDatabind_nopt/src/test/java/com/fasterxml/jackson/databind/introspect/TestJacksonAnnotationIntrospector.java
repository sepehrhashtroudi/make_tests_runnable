package com.fasterxml.jackson.databind.introspect;

import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import javax.xml.namespace.QName;

import com.fasterxml.jackson.annotation.*;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.jsontype.TypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.type.TypeFactory;

@SuppressWarnings("serial")
public class TestJacksonAnnotationIntrospector
    extends BaseMapTest
{
    public static enum EnumExample {
        VALUE1;
    }

    public static class JacksonExample
    {
        private String attributeProperty;
        private String elementProperty;
        private List<String> wrappedElementProperty;
        private EnumExample enumProperty;
        private QName qname;

        @JsonSerialize(using=QNameSerializer.class)
        public QName getQname()
        {
            return qname;
        }

        @JsonDeserialize(using=QNameDeserializer.class)
        public void setQname(QName qname)
        {
            this.qname = qname;
        }

        @JsonProperty("myattribute")
        public String getAttributeProperty()
        {
            return attributeProperty;
        }

        @JsonProperty("myattribute")
        public void setAttributeProperty(String attributeProperty)
        {
            this.attributeProperty = attributeProperty;
        }

        @JsonProperty("myelement")
        public String getElementProperty()
        {
            return elementProperty;
        }

        @JsonProperty("myelement")
        public void setElementProperty(String elementProperty)
        {
            this.elementProperty = elementProperty;
        }

        @JsonProperty("mywrapped")
        public List<String> getWrappedElementProperty()
        {
            return wrappedElementProperty;
        }

        @JsonProperty("mywrapped")
        public void setWrappedElementProperty(List<String> wrappedElementProperty)
        {
            this.wrappedElementProperty = wrappedElementProperty;
        }

        public EnumExample getEnumProperty()
        {
            return enumProperty;
        }

        public void setEnumProperty(EnumExample enumProperty)
        {
            this.enumProperty = enumProperty;
        }
    }

    public static class QNameSerializer extends JsonSerializer<QName> {

        @Override
        public void serialize(QName value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException
        {
            jgen.writeString(value.toString());
        }
    }


    public static class QNameDeserializer extends StdDeserializer<QName>
    {
        public QNameDeserializer() { super(QName.class); }
        @Override
        public QName deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException
        {
            return QName.valueOf(jp.readValueAs(String.class));
        }
    }

    public static class DummyBuilder extends StdTypeResolverBuilder
    //<DummyBuilder>
    {
    }

    @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS)
    @JsonTypeResolver(DummyBuilder.class)
    static class TypeResolverBean { }

    // @since 1.7
    @JsonIgnoreType
    static class IgnoredType { }

    static class IgnoredSubType extends IgnoredType { }

    // Test to ensure we can override enum settings
    static class LcEnumIntrospector extends JacksonAnnotationIntrospector
    {
        private static final long serialVersionUID = 1L;
        @Override
        public String findEnumValue(Enum<?> value)
        {
            return value.name().toLowerCase();
        }
    }
    
    /*
    /**********************************************************
    /* Unit tests
    /**********************************************************
     */
    
    /**
     * tests getting serializer/deserializer instances.
     */
public void testFindDeserializationName103() { Map<String, Object> properties = new HashMap<String, Object>(); properties.put("prop1", "val1"); properties.put("prop2", "val2"); properties.put("prop3", "val3"); properties.put("prop4", "val4"); properties.put("prop5", "val5"); properties.put("prop6", "val6"); properties.put("prop7", "val7"); properties.put("prop8", "val8"); properties.put("prop9", "val9"); properties.put("prop10", "val10"); properties.put("prop11", "val11");
}

    

        

    /**
     * Tests to ensure that {@link JsonIgnoreType} is detected as expected
     * by the standard introspector.
     * 
     * @since 1.7
     */
    

    
}
