package com.abryant;
enum ArmorType {
    LIGHT,
    MEDIUM,
    HEAVY
}

public enum Armor implements Item {
    LEATHER("Leather", 10, 10, 11, ArmorType.LIGHT);

    private final String name;
    private final double value;
    private final double weight;
    private final int baseArmorClass;
    private final ArmorType armorType;
    private final int strengthRequirement; // -1 = no strength requirement
    private final boolean stealthDisadvantage;

    Armor(final String name,
      final double value,
      final double weight,
      final int baseArmorClass,
      final ArmorType armorType) {
        this(name, value, weight, baseArmorClass, armorType, -1, false);
    }

    Armor(final String name,
          final double value,
          final double weight,
          final int baseArmorClass,
          final ArmorType armorType,
          final int strengthRequirement,
          final boolean stealthDisadvantage) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.baseArmorClass = baseArmorClass;
        this.armorType = armorType;
        this.strengthRequirement = strengthRequirement;
        this.stealthDisadvantage = stealthDisadvantage;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public int getBaseArmorClass() {
        return baseArmorClass;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public int getStrengthRequirement() {
        return strengthRequirement;
    }

    public boolean isStealthDisadvantage() {
        return stealthDisadvantage;
    }
}
