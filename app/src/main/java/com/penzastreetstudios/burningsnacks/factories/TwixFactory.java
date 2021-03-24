package com.penzastreetstudios.burningsnacks.factories;

import com.penzastreetstudios.burningsnacks.snacks.ISnack;
import com.penzastreetstudios.burningsnacks.snacks.Twix;

public class TwixFactory implements IFactory {
    @Override
    public ISnack create() {
        return new Twix();
    }
}
