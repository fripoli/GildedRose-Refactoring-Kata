package com.gildedrose

enum class ItemType {
    BRIE {
        override fun update(item: Item) = with(item) {
            increaseQuality()
            degradeSellIn()

            if (isSellInNegative()) {
                increaseQuality()
            }
        }
    },

    BACKSTAGE_PASS {
        override fun update(item: Item) = with(item) {
            when {
                isSellInNegative() -> quality = 0
                sellIn < 6 -> increaseQuality(3)
                sellIn < 11 -> increaseQuality(2)
                else -> increaseQuality()
            }

            degradeSellIn()
        }
    },

    SULFURAS {
        override fun update(item: Item) {}
    },

    REGULAR {
        override fun update(item: Item) = with(item) {
            degradeQuality()
            degradeSellIn()

            if (isSellInNegative()) {
                degradeQuality()
            }
        }
    };

    abstract fun update(item: Item)
}
