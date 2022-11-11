/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Test class for StrLookup.
 *
 * @version $Id$
 */
public class StrLookupTest  {

    //-----------------------------------------------------------------------
@Test
public void testNoneLookup4734() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 }
@Test
public void testNoneLookup6972() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 }
@Test
public void testSystemProperiesLookup7120() { 
     assertEquals(System.getProperty("os.name"), StrLookup.systemPropertiesLookup().lookup("os.name")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("other")); 
     try { 
         StrLookup.systemPropertiesLookup().lookup(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testNoneLookup8053() { 
     assertEquals(null, StrLookup.noneLookup().lookup(null)); 
     assertEquals(null, StrLookup.noneLookup().lookup("")); 
     assertEquals(null, StrLookup.noneLookup().lookup("any")); 
 }
@Test
public void testSystemProperiesLookup8342() { 
     assertEquals(System.getProperty("os.name"), StrLookup.systemPropertiesLookup().lookup("os.name")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("")); 
     assertEquals(null, StrLookup.systemPropertiesLookup().lookup("other")); 
     try { 
         StrLookup.systemPropertiesLookup().lookup(null); 
         fail(); 
     } catch (final NullPointerException ex) { 
     } 
 }
@Test
public void testToString9571() { 
         assertEquals("{}", StrLookup.toString(null)); 
         assertEquals("{}", StrLookup.toString(new Object[0])); 
         assertEquals("{}", StrLookup.toString(new String[0])); 
         assertEquals("{<null>}", StrLookup.toString(new String[] {null})); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", StrLookup.toString(null, "<empty>")); 
         assertEquals("{}", StrLookup.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", StrLookup.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", StrLookup.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testNoneLookup9852() { 
         assertEquals(null, StrLookup.noneLookup().lookup("none")); 
     }
@Test
public void testNoneLookup9853() { 
         assertEquals(null, StrLookup.noneLookup().lookup(null)); 
         assertEquals(null, StrLookup.noneLookup().lookup("")); 
         assertEquals(null, StrLookup.noneLookup().lookup("any")); 
     }
@Test
public void testNoneLookup9854() { 
         assertEquals(null, StrLookup.noneLookup().lookup("none")); 
         assertEquals(null, StrLookup.noneLookup().lookup("any")); 
     }
@Test
public void testNoneLookup9855() { 
         assertEquals(null, StrLookup.noneLookup().lookup("none")); 
         assertEquals(null, StrLookup.noneLookup().lookup("any")); 
     }
@Test
public void testMapLookup9856() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("some key", "some value"); 
         map.put("another key", "another value"); 
         assertEquals("some value", StrLookup.mapLookup("some key").lookup("some")); 
         assertEquals("another value", StrLookup.mapLookup("another key").lookup("another")); 
     }
@Test
public void testMapLookup_String9857() { 
         assertEquals(null, StrLookup.mapLookup("").lookup("any")); 
         assertEquals(null, StrLookup.mapLookup("any").lookup("any")); 
         assertEquals(null, StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
          
         assertEquals("any", StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
          
         assertEquals("any", StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
     }
@Test
public void testNullMap9858() { 
         assertEquals(null, StrLookup.noneLookup().lookup(null)); 
         assertEquals(null, StrLookup.noneLookup().lookup("")); 
         assertEquals(null, StrLookup.noneLookup().lookup("any")); 
     }
@Test
public void testNoneLookup9859() { 
         assertEquals(null, StrLookup.noneLookup().lookup(null)); 
         assertEquals(null, StrLookup.noneLookup().lookup("")); 
         assertEquals(null, StrLookup.noneLookup().lookup("any")); 
     }
@Test
public void testMapLookup9860() { 
         final Map<String, String> map = new HashMap<String, String>(); 
         map.put("some key", "some value"); 
         map.put("another key", "another value"); 
         assertEquals("some value", StrLookup.mapLookup("some key").lookup("some")); 
         assertEquals("another value", StrLookup.mapLookup("another key").lookup("another")); 
     }
@Test
public void testToString9861() { 
         assertEquals("{}", StrLookup.toString(null)); 
         assertEquals("{}", StrLookup.toString(new Object[0])); 
         assertEquals("{}", StrLookup.toString(new String[0])); 
         assertEquals("{<null>}", StrLookup.toString(new String[] {null})); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", StrLookup.toString(null, "<empty>")); 
         assertEquals("{}", StrLookup.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", StrLookup.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", StrLookup.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", StrLookup.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testMapLookup_String9862() { 
         assertEquals(null, StrLookup.mapLookup("").lookup("any")); 
         assertEquals(null, StrLookup.mapLookup("any").lookup("any")); 
         assertEquals(null, StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
          
         assertEquals("any", StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
          
         assertEquals("any", StrLookup.mapLookup("any").lookup("any")); 
         try { 
             StrLookup.mapLookup("any").lookup("any"); 
             fail(); 
         } catch (final IllegalStateException ex) { 
             // expected 
         } 
     }
    

    

    

    

}
