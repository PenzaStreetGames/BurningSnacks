package com.penzastreetstudios.burningsnacks.snacks;

public class Snickers implements ISnack {
    @Override
    public String getName() {
        return "snickers";
    }

    @Override
    public int getPrice() {
        return 30;
    }
}
