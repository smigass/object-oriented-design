package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Item;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class FoodItem extends Item {
    private Date eatByDate;

    public FoodItem(Item item, LocalDate eatByDate) {
        super(item.getName(), item.getCategory(), item.getQuantity(), item.getPrice());
        this.eatByDate = Date.from(eatByDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public Date getEatByDate() {
        return eatByDate;
    }

    public void setEatByDate(Date eatByDate) {
        this.eatByDate = eatByDate;
    }

    public String getFormattedEatByDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(eatByDate);
    }
}