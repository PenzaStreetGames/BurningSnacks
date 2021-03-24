package com.penzastreetstudios.burningsnacks.snacks;

public class Pepsi implements ISnack {
    @Override
    public String getName() {
        return "pepsi";
    }

    @Override
    public int getPrice() {
        return 40;
    }
}
