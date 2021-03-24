package com.penzastreetstudios.burningsnacks.snacks;

public class Cola implements ISnack {
    @Override
    public String getName() {
        return "cola";
    }

    @Override
    public int getPrice() {
        return 50;
    }
}
