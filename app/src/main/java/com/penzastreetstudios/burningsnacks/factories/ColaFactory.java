package com.penzastreetstudios.burningsnacks.factories;

import com.penzastreetstudios.burningsnacks.snacks.Cola;
import com.penzastreetstudios.burningsnacks.snacks.ISnack;

public class ColaFactory implements IFactory {
    @Override
    public ISnack create() {
        return new Cola();
    }
}
