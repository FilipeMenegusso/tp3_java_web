package br.edu.infnet.integration.apichallenges.dto;

import java.util.Locale;

public class Item {
    private int id;
    private String type;
    private String isbn13;
    private double price;
    private int numberinstock;

    protected Item() { }

    public Item(
            String type,
            String isbn13,
            double price,
            int numberinstock
    ) {
        this.type = type;
        this.isbn13 = isbn13;
        this.price = price;
        this.numberinstock = numberinstock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberinstock() {
        return numberinstock;
    }

    public void setNumberinstock(int numberinstock) {
        this.numberinstock = numberinstock;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Book: %s, ISBN: %s, Price: %.2f", this.id, this.type, this.isbn13, this.price);
    }

    public String ToJson() {
        return String.format(
                Locale.ENGLISH,
                "{\"type\":\"%s\",\"isbn13\":\"%s\",\"price\":%.2f,\"numberinstock\":%d}",
                this.type, this.isbn13, this.price, this.numberinstock
        );
    }
}


