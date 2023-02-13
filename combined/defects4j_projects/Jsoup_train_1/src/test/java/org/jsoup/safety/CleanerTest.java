package org.jsoup.safety;

import org.jsoup.Jsoup;
import org.jsoup.TextUtil;
import org.jsoup.safety.Whitelist;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 Tests for the cleaner.

 @author Jonathan Hedley, jonathan@hedley.net */
public class CleanerTest {
@Test
public void testIsValid2() { 
     String ok = "<p>Test <b><a href='http://example.com/'>OK</a></b></p>"; 
     String nok1 = "<p><script></script>Not <b>OK</b></p>"; 
     String nok2 = "<p align=right>Test Not <b>OK</b></p>"; 
     assertTrue(Jsoup.isValid(ok, Whitelist.basic())); 
     assertFalse(Jsoup.isValid(nok1, Whitelist.basic())); 
     assertFalse(Jsoup.isValid(nok2, Whitelist.basic())); 
 }
@Test
public void testDropXmlProc5() { 
     String h = "<?import namespace=\"xss\"><p>Hello</p>"; 
     String cleanHtml = Jsoup.clean(h, Whitelist.relaxed()); 
     assertEquals("<p>Hello</p>", cleanHtml); 
 }
@Test
public void testCleanJavascriptHref13() { 
     String h = "<A HREF=\"javascript:document.location='http://www.google.com/'\">XSS</A>"; 
     String cleanHtml = Jsoup.clean(h, Whitelist.relaxed()); 
     assertEquals("<a>XSS</a>", cleanHtml); 
 }
@Test
public void testHandlesEmptyAttributes24() { 
     String h = "<img alt=\"\" src= unknown=''>"; 
     String cleanHtml = Jsoup.clean(h, Whitelist.basicWithImages()); 
     assertEquals("<img alt=\"\" />", cleanHtml); 
 }
@Test
public void simpleBehaviourTest2() { 
     String h = "Hello <b>there</b>!"; 
     String cleanHtml = Jsoup.clean(h, Whitelist.simpleText()); 
     assertEquals("Hello <b>there</b>!", TextUtil.stripNewlines(cleanHtml)); 
 }
@Test
public void basicWithImagesTest() { 
     String h = "<div><p><img src='http://example.com/' alt=Image></p><p><img src='ftp://ftp.example.com'></p></div>"; 
     String cleanHtml = Jsoup.clean(h, Whitelist.basicWithImages()); 
     assertEquals("<p><img src=\"http://example.com/\" alt=\"Image\" /></p><p><img /></p>", TextUtil.stripNewlines(cleanHtml)); 
 }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    
    

    
    
    
    
    
}
