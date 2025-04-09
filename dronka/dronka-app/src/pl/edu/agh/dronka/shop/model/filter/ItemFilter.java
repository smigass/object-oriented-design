package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.BookItem;
import pl.edu.agh.dronka.shop.model.items.ElectronicsItem;
import pl.edu.agh.dronka.shop.model.items.MusicItem;

public record ItemFilter(Item itemSpec) {


	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}

		if (itemSpec.isSecondhand() && !item.isSecondhand()) {
			return false;
		}

		if (itemSpec.isPolish() && !item.isPolish()) {
			return false;
		}


		switch (itemSpec.getCategory()) {
			case BOOKS -> {
				if (((BookItem) itemSpec).isHardCover() && !((BookItem) item).isHardCover()) {
					return false;
				}
			}
			case ELECTRONICS -> {
				if (((ElectronicsItem) itemSpec).hasWarranty() && !((ElectronicsItem) item).hasWarranty()) {
					return false;
				}

				if (((ElectronicsItem) itemSpec).isMobile() && !((ElectronicsItem) item).isMobile()) {
					return false;
				}
			}
			case MUSIC -> {
				if (((MusicItem) itemSpec).hasVideo() && !((MusicItem) item).hasVideo())
					return false;
			}
		}

		return true;
	}

}