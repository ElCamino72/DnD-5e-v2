package com.abryant;

import java.util.HashMap;
import java.util.Map;

import static com.abryant.Dice.D10;
import static com.abryant.Dice.D8;
import static com.abryant.WeaponProperty.VERSATILE;

enum WeaponProperty {
    LIGHT, HEAVY, VERSATILE,
    TWO_HANDED, FINESSE, THROWN,
    AMMUNITION, LOADING, REACH
}

public enum Weapon implements Item {
    LONGSWORD("Longsword", 15, 3, new HashMap<>(Map.of(D8, 1, D10, 1)), VERSATILE);

    private final String name;
    private final double value;
    private final double weight;
    private final HashMap<Dice, Integer> damage;
    private final WeaponProperty[] weaponProperties;

    Weapon(final String name, final double value, final double weight, final HashMap<Dice, Integer> damage, final WeaponProperty... weaponProperties) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.damage = damage;
        this.weaponProperties = weaponProperties;
    }

    public HashMap<Dice, Integer> getDamage() {
        return damage;
    }

    public WeaponProperty[] getWeaponProperties() {
        return weaponProperties;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
