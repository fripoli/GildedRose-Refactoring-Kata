package com.gildedrose

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            item.typeOf().update(item)
        }
    }
}

fun Item.typeOf(): ItemType {
    return with(name) {
        when {
            contains("Aged Brie") -> ItemType.BRIE
            startsWith("Backstage passes") -> ItemType.BACKSTAGE_PASS
            startsWith("Sulfuras") -> ItemType.SULFURAS
            else -> ItemType.REGULAR
        }
    }
}

fun Item.isQualityIncreaseable(): Boolean = quality < 50
fun Item.isQualityMin(): Boolean = quality == 0
fun Item.isSellInNegative(): Boolean = sellIn < 0

fun Item.increaseQuality(quantity: Int = 1) {
    if (isQualityIncreaseable()) {
        quality += 1
        if (quantity > 1) {
            increaseQuality(quantity - 1)
        }
    }
}

fun Item.degradeQuality(checkConjured: Boolean = true) {
    if (!isQualityMin()) {
        quality -= 1
    }
    if (checkConjured) isConjured()
}

fun Item.degradeSellIn() {
    sellIn -= 1
}

fun Item.isConjured() {
    if (name.contains("Conjured", true)) {
        degradeQuality(false)
    }
}
