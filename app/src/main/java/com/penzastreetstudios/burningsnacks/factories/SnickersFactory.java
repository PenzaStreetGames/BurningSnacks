package com.penzastreetstudios.burningsnacks.factories;

import com.penzastreetstudios.burningsnacks.snacks.ISnack;
import com.penzastreetstudios.burningsnacks.snacks.Snickers;

public class SnickersFactory implements IFactory {
    @Override
    public ISnack create() {
        return new Snickers();
    }
}
