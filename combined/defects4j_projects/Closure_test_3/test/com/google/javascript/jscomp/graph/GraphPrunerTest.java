/*
 * Copyright 2011 The Closure Compiler Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.javascript.jscomp.graph;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;

import junit.framework.TestCase;

/**
 * @author nicksantos@google.com (Nick Santos)
 */
public class GraphPrunerTest extends TestCase {

public void testFourNodesConnected1562() { 
     DiGraph<String, String> graph = LinkedDirectedGraph.create(); 
     graph.createNode("A"); 
     graph.createNode("B"); 
     graph.createNode("C"); 
     graph.createNode("D"); 
     graph.connect("A", "--", "C"); 
     graph.connect("B", "--", "C"); 
     graph.connect("C", "--", "D"); 
     graph.connect("A", "--", "D"); 
     DiGraph<String, String> pruned = new GraphPruner<String, String>(graph).prune(Predicates.not(Predicates.equalTo("C"))); 
     assertEquals(3, pruned.getNodes().size()); 
     assertTrue(pruned.isConnectedInDirection("A", "D")); 
     assertTrue(pruned.isConnectedInDirection("B", "D")); 
     assertFalse(pruned.isConnectedInDirection("A", "B")); 
 }
public void testFourNodesConnected2563() { 
     DiGraph<String, String> graph = LinkedDirectedGraph.create(); 
     graph.createNode("A"); 
     graph.createNode("B"); 
     graph.createNode("C"); 
     graph.createNode("D"); 
     graph.connect("A", "--", "C"); 
     graph.connect("B", "--", "C"); 
     graph.connect("C", "--", "D"); 
     graph.connect("A", "--", "D"); 
     DiGraph<String, String> pruned = new GraphPruner<String, String>(graph).prune(Predicates.not(Predicates.equalTo("C"))); 
     assertEquals(3, pruned.getNodes().size()); 
     assertTrue(pruned.isConnected("A", "D")); 
     assertTrue(pruned.isConnected("B", "D")); 
     assertFalse(pruned.isConnected("A", "B")); 
 }
public void testFourNodes564() { 
     DiGraph<String, String> graph = LinkedDirectedGraph.create(); 
     graph.createNode("A"); 
     graph.createNode("B"); 
     graph.createNode("C"); 
     graph.createNode("D"); 
     graph.connect("A", "--", "C"); 
     graph.connect("B", "--", "C"); 
     graph.connect("C", "--", "D"); 
     graph.connect("A", "--", "D"); 
     DiGraph<String, String> pruned = new GraphPruner<String, String>(graph).prune(Predicates.not(Predicates.equalTo("C"))); 
     assertEquals(3, pruned.getNodes().size()); 
     assertTrue(pruned.isConnected("A", "D")); 
     assertTrue(pruned.isConnected("B", "D")); 
     assertFalse(pruned.isConnected("A", "B")); 
 }
  

  

  

  

  
}
