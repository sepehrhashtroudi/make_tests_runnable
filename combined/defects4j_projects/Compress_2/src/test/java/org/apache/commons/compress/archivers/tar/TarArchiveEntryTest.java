/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import junit.framework.TestCase;

public class TarArchiveEntryTest extends TestCase {

    private static final String OS =
        System.getProperty("os.name").toLowerCase(Locale.US);
    private static final String ROOT =
        OS.startsWith("windows") || OS.startsWith("netware") ? "C:\\" : "/";

    /**
     * JIRA issue SANDBOX-284
     *
     * @see "https://issues.apache.org/jira/browse/SANDBOX-284"
     */
public void testFileSystemRoot18() { 
     TarArchiveEntry t = new TarArchiveEntry(new File(ROOT)); 
     assertEquals("/", t.getName()); 
 }
    

    
}
