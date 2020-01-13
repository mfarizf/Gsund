package com.example.gsund.ui.main;

public class ItemOption {
    private final int id;
    private final String name;
    private final String text;
    private final int image;

    public ItemOption(int id, String name, String text, int image) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }
}
