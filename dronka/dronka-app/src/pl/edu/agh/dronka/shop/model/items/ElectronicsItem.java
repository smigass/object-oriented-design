package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Item;

public class ElectronicsItem extends Item {
    private boolean mobile;
    private boolean warranty;

    public ElectronicsItem(Item item, boolean mobile, boolean warranty) {
        super(item.getName(), item.getCategory(), item.getQuantity(), item.getPrice());
        this.mobile = mobile;
        this.warranty = warranty;
    }

    public ElectronicsItem() {}

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean hasWarranty() {
        return warranty;
    }

    public void setWarranty(boolean warranty) {
        this.warranty = warranty;
    }
}