package org.jsoup.nodes;

import org.jsoup.Jsoup;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 Test TextNodes

 @author Jonathan Hedley, jonathan@hedley.net */
public class TextNodeTest {
@Test
public void testTextBean1() { 
     Document doc = Jsoup.parse("<p>One <span>two</span> three</p>"); 
     Element p = doc.select("p").first(); 
     TextNode tn = (TextNode) p.childNode(2); 
     assertEquals(" three", tn.text()); 
     tn.text(" POW!"); 
     assertEquals("One <span>two</span> POW!", p.html()); 
 }
    
    
    
}
