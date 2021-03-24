package com.penzastreetstudios.burningsnacks.factories;

import com.penzastreetstudios.burningsnacks.snacks.ISnack;
import com.penzastreetstudios.burningsnacks.snacks.Pepsi;

public class PepsiFactory implements IFactory {
    @Override
    public ISnack create() {
        return new Pepsi();
    }
}
