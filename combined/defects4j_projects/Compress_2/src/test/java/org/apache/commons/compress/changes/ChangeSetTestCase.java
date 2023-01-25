/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.compress.changes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.AbstractTestCase;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.ar.ArArchiveEntry;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;

/**
 * Checks several ChangeSet business logics.
 */
public final class ChangeSetTestCase extends AbstractTestCase {
    /**
     * Tries to delete the folder "bla" from a zip file. This should result in
     * the deletion of bla/*, which actually means bla/test4.xml should be
     * removed from this zipfile. The file something/bla (without ending, named
     * like the folder) should not be deleted.
     * 
     * @throws Exception
     */
public void testDeleteFromAndAddToTar1() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         final File input = getFile("bla.tar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("tar", is); 
         temp = new File(dir, "bla.tar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("tar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     this.checkArchiveContent(temp, expected); 
 }
public void testDeleteFromAndAddToTar2() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         final File file1 = getFile("test.txt"); 
         final TarArchiveEntry entry = new TarArchiveEntry("testdata/test.txt"); 
         entry.setModTime(0); 
         entry.setSize(file1.length()); 
         entry.setUserId(0); 
         entry.setGroupId(0); 
         entry.setUserName("avalon"); 
         entry.setGroupName("excalibur"); 
         entry.setMode(0100000); 
         changes.add(entry, new FileInputStream(file1)); 
         final File input = getFile("bla.tar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("tar", is); 
         temp = new File(dir, "bla.tar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("tar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     expected.add("testdata/test.txt"); 
     expected.add("testdata/test.txt"); 
     expected.add("testdata/test.txt"); 
     this.checkArchiveContent(temp, expected); 
 }
public void testDeleteFromTar9() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         final File input = getFile("bla.tar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("tar", is); 
         temp = new File(dir, "bla.tar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("tar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     this.checkArchiveContent(temp, expected); 
 }
public void testDelete25() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         changes.delete("META-INF"); 
         changes.delete(".classpath"); 
         changes.delete(".project"); 
         changes.delete(".project"); 
         final File input = getFile("bla.jar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("jar", is); 
         temp = new File(dir, "bla.jar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("jar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     this.checkArchiveContent(temp, expected); 
 }
public void testDeleteFromAndAddToTar26() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         changes.delete("META-INF"); 
         changes.delete(".classpath"); 
         changes.delete(".project"); 
         changes.delete(".project"); 
         final File input = getFile("bla.tar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("tar", is); 
         temp = new File(dir, "bla.tar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("tar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     this.checkArchiveContent(temp, expected); 
 }
public void testDeleteFromAndAddToTar27() throws Exception { 
     ArchiveOutputStream out = null; 
     ArchiveInputStream ais = null; 
     File temp = null; 
     try { 
         ChangeSet changes = new ChangeSet(); 
         changes.delete("test2.xml"); 
         changes.delete("META-INF"); 
         changes.delete(".classpath"); 
         changes.delete(".project"); 
         changes.delete(".project"); 
         changes.delete(".project"); 
         final File input = getFile("bla.tar"); 
         final InputStream is = new FileInputStream(input); 
         ais = new ArchiveStreamFactory().createArchiveInputStream("tar", is); 
         temp = new File(dir, "bla.tar"); 
         out = new ArchiveStreamFactory().createArchiveOutputStream("tar", new FileOutputStream(temp)); 
         changes.perform(ais, out); 
     } finally { 
         if (out != null) 
             out.close(); 
         if (ais != null) 
             ais.close(); 
     } 
     List expected = new ArrayList(); 
     expected.add("test1.xml"); 
     this.checkArchiveContent(temp, expected); 
 }
    

    /**
     * Tries to delete the file "bla/test5.xml" from a zip file. This should
     * result in the deletion of "bla/test5.xml".
     * 
     * @throws Exception
     */
    

    /**
     * Tries to delete a directory with a file and adds a new directory with a
     * new file and with the same name. Should delete dir1/* and add
     * dir1/test.txt at the end
     * 
     * @throws Exception
     */
    

    /**
     * Adds a file to a zip archive. Deletes an other file.
     * 
     * @throws Exception
     */
    

    /**
     * add blub/test.txt + delete blub Should add dir1/test.txt and delete it
     * afterwards. In this example, the zip archive should stay untouched.
     * 
     * @throws Exception
     */
    

    /**
     * delete bla + add bla/test.txt + delete bla Deletes dir1/* first, then
     * surpresses the add of bla.txt cause there is a delete operation later.
     * 
     * @throws Exception
     */
    

    /**
     * Simple Delete from a zip file.
     * 
     * @throws Exception
     */
    

    /**
     * Simple delete from a tar file
     * 
     * @throws Exception
     */
    

    /**
     * Simple delete from a jar file
     * 
     * @throws Exception
     */
    

    

    /**
     * Delete from a jar file and add another file
     * 
     * @throws Exception
     */
    

    /**
     * Simple delete from an ar file
     * 
     * @throws Exception
     */
    

    /**
     * Deletes a file from an AR-archive and adds another
     * 
     * @throws Exception
     */
    

    /**
     * TODO: Move operations are not supported currently
     * 
     * mv dir1/test.text dir2/test.txt + delete dir1 Moves the file to dir2 and
     * deletes everything in dir1
     * 
     * @throws Exception
     */
    

    /**
     * TODO: Move operations are not supported currently
     * 
     * add dir1/bla.txt + mv dir1/test.text dir2/test.txt + delete dir1
     * 
     * Add dir1/bla.txt should be surpressed. All other dir1 files will be
     * deleted, except dir1/test.text will be moved
     * 
     * @throws Exception
     */
    
}
