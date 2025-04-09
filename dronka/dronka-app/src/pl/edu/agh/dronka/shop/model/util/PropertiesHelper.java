package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.BookItem;
import pl.edu.agh.dronka.shop.model.items.ElectronicsItem;
import pl.edu.agh.dronka.shop.model.items.FoodItem;
import pl.edu.agh.dronka.shop.model.items.MusicItem;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		
		propertiesMap.put("Nazwa", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName()); 
		propertiesMap.put("Ilość", Integer.toString(item.getQuantity()));
		propertiesMap.put("Tanie bo polskie", item.isPolish());
		propertiesMap.put("Używany", item.isSecondhand());

		switch (item.getCategory()) {
			case BOOKS -> {
				propertiesMap.put("Liczba stron", ((BookItem)item).getPages());
				propertiesMap.put("Twarda okładka", ((BookItem)item).isHardCover());
			}
			case ELECTRONICS -> {
				propertiesMap.put("Urządzenie mobilne", ((ElectronicsItem)item).isMobile());
				propertiesMap.put("Gwarancja", ((ElectronicsItem)item).hasWarranty());
			}
			case FOOD -> {
				propertiesMap.put("Spożyć do", ((FoodItem)item).getFormattedEatByDate());
			}
			case MUSIC -> {
				propertiesMap.put("Gatunek muzyczny", ((MusicItem)item).getGenre());
				propertiesMap.put("Dołączone wideo", ((MusicItem)item).hasVideo());
			}
		}
		
		return propertiesMap;
	}
}
