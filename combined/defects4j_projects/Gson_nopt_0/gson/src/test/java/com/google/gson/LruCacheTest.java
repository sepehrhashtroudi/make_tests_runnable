/*
 * Copyright (C) 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gson;

import junit.framework.TestCase;

/**
 * Unit test for the {@link LruCache} class.
 *
 * @author Inderjeet Singh
 * @author Joel Leitch
 */
public class LruCacheTest extends TestCase {

public void testGetElement218() { LruCache<String, String> cache = new LruCache<String, String>(3); cache.addElement("a", "a"); cache.addElement("b", "b"); cache.addElement("c", "c"); assertEquals("a", cache.getElement("a")); assertEquals("b", cache.getElement("b")); assertEquals("c", cache.getElement("c")); }
public void testGetElement219() { LruCache<String, String> cache = new LruCache<String, String>(3); cache.addElement("A", "A"); cache.addElement("B", "B"); cache.addElement("C", "C"); assertEquals("A", cache.getElement("A")); assertEquals("B", cache.getElement("B")); assertEquals("C", cache.getElement("C")); assertNull(cache.getElement("D")); }
  
  
  
  
  
}
