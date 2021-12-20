package com.elysian.java.training.d01.s4;

import java.util.Arrays;

public enum ElectronicsTypes {
    WASHING_MACHINE(1, "Washing"),
    FRIDGE(2, "Storage"),
    STOVE(3, "Cooking");

    private final int id;
    private final String usage;

    ElectronicsTypes(int id, String usage) {
        this.id = id;
        this.usage = usage;
    }

    public static ElectronicsTypes byUsage(String usage) {
        return Arrays.stream(values())
                     .filter(item -> item.getUsage().equals(usage))
                     .findFirst()
                     .orElseThrow(() -> new IllegalArgumentException("No entry found"));
    }

    public int getId() {
        return id;
    }

    public String getUsage() {
        return usage;
    }
}
