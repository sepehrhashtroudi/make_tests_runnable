/*
 *
 * ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Rhino code, released
 * May 6, 1999.
 *
 * The Initial Developer of the Original Code is
 * Netscape Communications Corporation.
 * Portions created by the Initial Developer are Copyright (C) 1997-1999
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Nick Santos
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU General Public License Version 2 or later (the "GPL"), in which
 * case the provisions of the GPL are applicable instead of those above. If
 * you wish to allow use of your version of this file only under the terms of
 * the GPL and not to allow others to use your version of this file under the
 * MPL, indicate your decision by deleting the provisions above and replacing
 * them with the notice and other provisions required by the GPL. If you do
 * not delete the provisions above, a recipient may use your version of this
 * file under either the MPL or the GPL.
 *
 * ***** END LICENSE BLOCK ***** */

package com.google.javascript.rhino.jstype;

import static com.google.javascript.rhino.jstype.TernaryValue.FALSE;
import static com.google.javascript.rhino.jstype.TernaryValue.TRUE;
import static com.google.javascript.rhino.jstype.TernaryValue.UNKNOWN;

import junit.framework.TestCase;

/**
 * Tests the behavior of {@link TernaryValue} by verifying the truth tables
 * of the operations {@link TernaryValue#and(TernaryValue)},
 * {@link TernaryValue#not()}, {@link TernaryValue#or(TernaryValue)}
 * and {@link TernaryValue#xor(TernaryValue)} as well as the
 * {@link TernaryValue#toBoolean(boolean)} method.
 *
 */
public class TernaryValueTest extends TestCase {
public void testXor355() throws Exception { 
     assertEquals(FALSE, TRUE.xor(TRUE)); 
     assertEquals(TRUE, TRUE.xor(FALSE)); 
     assertEquals(UNKNOWN, TRUE.xor(UNKNOWN)); 
     assertEquals(TRUE, FALSE.xor(TRUE)); 
     assertEquals(FALSE, FALSE.xor(FALSE)); 
     assertEquals(UNKNOWN, FALSE.xor(UNKNOWN)); 
     assertEquals(UNKNOWN, UNKNOWN.xor(TRUE)); 
     assertEquals(UNKNOWN, UNKNOWN.xor(FALSE)); 
     assertEquals(UNKNOWN, UNKNOWN.xor(UNKNOWN)); 
 }
  

  

  

  

  

  

  
}
