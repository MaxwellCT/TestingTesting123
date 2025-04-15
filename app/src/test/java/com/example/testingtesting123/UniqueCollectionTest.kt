package com.example.testingtesting123

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {
        val item = Item("item1")
        collection.addItem(item)
        assert(collection.size() == 1) { "Item was not added" }
        assert(collection.get(0).name == "item1") { "Item name does not match" }
    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {
        val item1 = Item("item1")
        val item2 = Item("item1")
        val item3 = Item("item2")

        collection.addItem(item1)
        collection.addItem(item2)
        collection.addItem(item3)

        assert(collection.size() == 2) { "Duplicate item was added" }
        assert(collection.get(0).name == "item1") { "First item name mismatch" }
        assert(collection.get(1).name == "item2") { "Second item name mismatch" }
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}