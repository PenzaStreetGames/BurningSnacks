package com.penzastreetstudios.burningsnacks.singletones;

import com.penzastreetstudios.burningsnacks.Machine;
import com.penzastreetstudios.burningsnacks.factories.ColaFactory;
import com.penzastreetstudios.burningsnacks.factories.IFactory;
import com.penzastreetstudios.burningsnacks.factories.PepsiFactory;
import com.penzastreetstudios.burningsnacks.factories.SnickersFactory;
import com.penzastreetstudios.burningsnacks.factories.TwixFactory;
import com.penzastreetstudios.burningsnacks.snacks.ISnack;

import java.util.ArrayList;
import java.util.Random;

public class Delivery {
    private static Delivery delivery;
    ArrayList<IFactory> factories = new ArrayList<>();

    public static Delivery getDelivery() {
        if (delivery == null)
            delivery = new Delivery();
        return delivery;
    }

    private Delivery() {
        factories.add(new ColaFactory());
        factories.add(new PepsiFactory());
        factories.add(new SnickersFactory());
        factories.add(new TwixFactory());
    }

    public void fillAutomat(Machine machine, int snacksAmount) {
        for (int i = 0; i < snacksAmount; i++) {
            Random r = new Random();
            int index = r.nextInt(4);
            ISnack snack = factories.get(index).create();
            machine.addSnack(snack);
        }
    }
}
