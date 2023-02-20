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

import com.google.javascript.rhino.testing.BaseJSTypeTestCase;

public class PrototypeObjectTypeTest extends BaseJSTypeTestCase {

public void testNumberObjectType49() throws Exception { 
     assertFalse(NUMBER_OBJECT_TYPE.isArrayType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isBooleanObjectType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isBooleanValueType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isDateType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isEnumElementType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isNamedType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isNullType()); 
     assertTrue(NUMBER_OBJECT_TYPE.isNumber()); 
     assertTrue(NUMBER_OBJECT_TYPE.isNumberObjectType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isNumberValueType()); 
     assertTrue(NUMBER_OBJECT_TYPE.isObject()); 
     assertFalse(NUMBER_OBJECT_TYPE.isFunctionPrototypeType()); 
     assertTrue(NUMBER_OBJECT_TYPE.getImplicitPrototype().isFunctionPrototypeType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isRegexpType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isString()); 
     assertFalse(NUMBER_OBJECT_TYPE.isStringObjectType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isStringValueType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isEnumType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isUnionType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isStruct()); 
     assertFalse(NUMBER_OBJECT_TYPE.isDict()); 
     assertFalse(NUMBER_OBJECT_TYPE.isAllType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isVoidType()); 
     assertFalse(NUMBER_OBJECT_TYPE.isConstructor()); 
     assertTrue(NUMBER_OBJECT_TYPE.isInstanceType()); 
     assertTypeEquals(NUMBER_OBJECT_TYPE, NUMBER_TYPE.autoboxesTo()); 
     assertTypeEquals(NUMBER_TYPE, NUMBER_OBJECT_TYPE.unboxesTo()); 
     assertTrue(NUMBER_OBJECT_TYPE.isSubtype(ALL_TYPE));
}

  
}
