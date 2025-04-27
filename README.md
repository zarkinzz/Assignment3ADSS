# Assignment 3 — Algorithms and Data Structures

## Overview

This project presents custom implementations of two fundamental data structures:

- **MyHashTable&lt;K, V&gt;** — a custom-built hash table using separate chaining and dynamic resizing.
- **BST&lt;K, V&gt;** — a non-recursive binary search tree with an iterator for in-order traversal.

## Part 1: MyHashTable&lt;K, V&gt;

### Main Features:
- Private nested class **HashNode&lt;K, V&gt;** to represent key-value pairs.
- **put(K key, V value)** — adds a new entry or updates an existing one.
- **get(K key)** — retrieves a value based on its key.
- **remove(K key)** — deletes an entry by its key.
- **contains(V value)** — checks if a value exists in the table.
- **getKey(V value)** — searches for a key based on a given value.
- Automatic resizing is triggered when the load factor exceeds **0.75**.

### Testing:
Testing is done through the **TestHashTable.java** file:
- Inserts 10,000 randomly generated entries using a custom class **MyTestingClass** as keys.
- Verifies data retrieval using **get()**.
- Displays the count of successfully found entries.

## Part 2: BST&lt;K, V&gt;

### Main Features:
- **put(K key, V value)** — adds elements iteratively.
- **get(K key)** — searches for elements without recursion.
- **delete(K key)** — removes nodes using iterative logic.
- **size()** — returns the number of elements stored.
- **iterator()** — provides an in-order traversal using an iterator, not recursion.
- **Entry&lt;K, V&gt;** — gives access to each key and value during iteration.

### Testing:
Tested with the **TestBST.java** file:
- Inserts multiple nodes into the tree.
- Prints the tree contents using the iterator.
- Demonstrates deletion operations and updates the tree size.

## How to Compile and Run

Open your terminal and use the following commands:

```bash
javac models/*.java test/*.java
java test.TestHashTable
java test.TestBST
