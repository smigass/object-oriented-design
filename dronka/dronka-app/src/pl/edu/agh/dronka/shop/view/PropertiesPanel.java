package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;
import pl.edu.agh.dronka.shop.model.items.BookItem;
import pl.edu.agh.dronka.shop.model.items.ElectronicsItem;
import pl.edu.agh.dronka.shop.model.items.MusicItem;

public class PropertiesPanel extends JPanel {

    private static final long serialVersionUID = -2804446079853846996L;
    private ShopController shopController;

    private ItemFilter filter = new ItemFilter(new Item());

    public PropertiesPanel(ShopController shopController) {
        this.shopController = shopController;
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    public void fillProperties() {
        removeAll();

        switch (shopController.getCurrentCategory()) {
            case BOOKS -> filter = new ItemFilter(new BookItem());
            case ELECTRONICS -> filter = new ItemFilter(new ElectronicsItem());
            case MUSIC -> filter = new ItemFilter(new MusicItem());
            default -> filter = new ItemFilter(new Item());
        }

        filter.itemSpec().setCategory(shopController.getCurrentCategory());
        add(createPropertyCheckbox("Tanie bo polskie", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                filter.itemSpec().setPolish(
                        ((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }
        }));

        add(createPropertyCheckbox("Używany", new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                filter.itemSpec().setSecondhand(
                        ((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }
        }));

        switch (shopController.getCurrentCategory()) {
            case BOOKS -> add(createPropertyCheckbox("Twadra oprawa", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    ((BookItem) filter.itemSpec()).setHardCover(
                            ((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }
            }));
            case ELECTRONICS -> {
                add(createPropertyCheckbox("Mobilny", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        ((ElectronicsItem) filter.itemSpec()).setMobile(
                                ((JCheckBox) event.getSource()).isSelected());
                        shopController.filterItems(filter);
                    }

                }));
                add(createPropertyCheckbox("Gwarancja", new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        ((ElectronicsItem) filter.itemSpec()).setWarranty(
                                ((JCheckBox) event.getSource()).isSelected());
                        shopController.filterItems(filter);
                    }
                }));
            }
            case MUSIC -> add(createPropertyCheckbox("Dołączone wideo", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    ((MusicItem) filter.itemSpec()).setHasVideo(
                            ((JCheckBox) event.getSource()).isSelected());
                    shopController.filterItems(filter);
                }
            }));

        }

    }

    private JCheckBox createPropertyCheckbox(String propertyName,
                                             ActionListener actionListener) {

        JCheckBox checkBox = new JCheckBox(propertyName);
        checkBox.setSelected(false);
        checkBox.addActionListener(actionListener);

        return checkBox;
    }

}
