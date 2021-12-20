package com.elysian.java.training.d01.s4;

public class EnumsUsage {

    public static void main(String[] args) {
        ElectronicsTypes types = ElectronicsTypes.FRIDGE;
        System.out.println(types.getUsage());

        switchingOnEnumEntry(types);

        ElectronicsTypes item = ElectronicsTypes.valueOf("FRIDGE");
        ElectronicsTypes byUsage = ElectronicsTypes.byUsage("Cooking");

        final ElectronicsTypes[] values = ElectronicsTypes.values();
        for (ElectronicsTypes value : values) {
            System.out.println(value);
        }

        if (item == byUsage) {
            System.out.println("They are equal");
        }

        if (item.ordinal() > byUsage.ordinal()) {
            System.out.println("The first has a bigger ordinal");
        }
    }

    private static void switchingOnEnumEntry(ElectronicsTypes types) {
        switch (types) {
            case STOVE: // do something
                return;

            case FRIDGE: // do something
                return;
        }
    }
}
