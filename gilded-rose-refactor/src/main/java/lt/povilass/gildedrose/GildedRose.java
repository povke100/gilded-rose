package lt.povilass.gildedrose;

public class GildedRose {

	public Item[] items;

	/*
	 * Mininum and maximum quality values
	 */
	private static final int MAX_QUALITY = 50;
	private static final int MIN_QUALITY = 0;

	/*
	 * Special items
	 */
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTG_PASS = "Backstage passes to a TAFKAL80ETC concert";
	private static final String CONJURED_FIX = "Conjured";

	/*
	 * Quality values for backstage pass
	 */
	private static final int PASS = 1;
	private static final int PASS_10 = 2;
	private static final int PASS_5 = 3;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {

			switch (items[i].name) {

			case AGED_BRIE:
				updateBrie(items[i]);
				break;
			case SULFURAS:
				break;
			case BACKSTG_PASS:
				updateBckPass(items[i]);
				break;
			default:
				updateItem(items[i]);
				break;
			}
		}
	}

	private boolean isNotMaxQuality(int quality) {
		return quality < MAX_QUALITY;
	}

	private boolean isNotMinQuality(int quality) {
		return quality > MIN_QUALITY;
	}

	private void updateBrie(Item brie) {

		if (isNotMaxQuality(brie.quality)) {
			brie.quality++;

			brie.sellIn--;
			if (brie.sellIn < 0 && isNotMaxQuality(brie.quality)) {
				brie.quality++;
			}
		} else {
			brie.sellIn--;
		}

	}

	private void updateBckPass(Item pass) {
		if (pass.sellIn >= 0) {

			// sellIn > 10 -> quality + 1;
			// 5 < sellIn <= 10 -> quality + 2;
			// sellIn < 5 -> quality + 3
			int quality = pass.sellIn <= 10 ? (pass.sellIn <= 5 ? PASS_5 : PASS_10) : PASS;

			//no need to check every time if quality is max value.
			pass.quality = isNotMaxQuality(pass.quality + quality) ? pass.quality + quality : MAX_QUALITY;

			pass.sellIn--;
			pass.quality = pass.sellIn < 0 ? MIN_QUALITY : pass.quality; // if sellIn < 0 -> quality = 0
		} else {
			pass.sellIn--;
		}
	}

	/*
	 * Added functionality for conjured items
	 */
	private void updateItem(Item item) {

		if (isNotMinQuality(item.quality)) {
			int conjMultl = item.name.contains(CONJURED_FIX) ? 2 : 1; // if item is conjured, it degrades twice as fast
																		
			item.quality = isNotMinQuality(item.quality - conjMultl) ? item.quality - conjMultl : MIN_QUALITY;

			item.sellIn--;
			if (item.sellIn < 0) {
				item.quality = isNotMinQuality(item.quality - conjMultl) ? item.quality - conjMultl : MIN_QUALITY;
			}

		} else {
			item.sellIn--;
		}

	}
}