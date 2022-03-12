package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("items")
    fun testItems(item: Item, sellIn: Int, quality: Int) {
        val app = GildedRose(arrayOf(item))
        app.updateQuality()
        assertEquals(item.name, app.items[0].name)
        assertEquals(sellIn, app.items[0].sellIn)
        assertEquals(quality, app.items[0].quality)
    }

    companion object {
        @JvmStatic
        fun items() = listOf(
            Arguments.of(Item("Aged Brie", 10, 10), 9, 11),
            Arguments.of(Item("Aged Brie", 0, 50), -1, 50),
            Arguments.of(Item("Aged Brie", -1, 40), -2, 42),
            Arguments.of(Item("Aged Brie", -1, 50), -2, 50),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 10, 10), 9, 12),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10), 2, 13),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 3, 50), 2, 50),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 3, 48), 2, 50),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", 15, 10), 14, 11),
            Arguments.of(Item("Backstage passes to a TAFKAL80ETC concert", -1, 10), -2, 0),
            Arguments.of(Item("Sulfuras, Hand of Ragnaros", 10, 10), 10, 10),
            Arguments.of(Item("Sulfuras, Hand of Ragnaros", 0, 100), 0, 100),
            Arguments.of(Item("Bla", 111, 10), 110, 9),
            Arguments.of(Item("Bla", -1, 10), -2, 8),
            Arguments.of(Item("Bla", 111, 0), 110, 0),
            Arguments.of(Item("Conjured Bla", 10, 10), 9, 8)
        )
    }

}
