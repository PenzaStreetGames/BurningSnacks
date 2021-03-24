package com.penzastreetstudios.burningsnacks.snacks;

public class Twix implements ISnack {
    @Override
    public String getName() {
        return "twix";
    }

    @Override
    public int getPrice() {
        return 20;
    }
}
