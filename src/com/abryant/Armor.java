package com.abryant;

public enum Armor implements Item {
    LEATHER("Leather", 10, 10, 11);

    private String name;
    private double value;
    private double weight;
    private int baseArmorClass;
    private int maxDexterityModBonus; // -1 = no maximum, -2 = dexterity is ignored
    private int strengthRequirement; // -1 = no strength requirement
    private boolean stealthDisadvantage;

    Armor(final String name,
      final double value,
      final double weight,
      final int baseArmorClass) {
        this(name, value, weight, baseArmorClass, -1, -1, false);
    }

    Armor(final String name,
          final double value,
          final double weight,
          final int baseArmorClass,
          final int maxDexterityModBonus,
          final int strengthRequirement,
          final boolean stealthDisadvantage) {
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.baseArmorClass = baseArmorClass;
        this.maxDexterityModBonus = maxDexterityModBonus;
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

    public int getMaxDexterityModBonus() {
        return maxDexterityModBonus;
    }

    public int getStrengthRequirement() {
        return strengthRequirement;
    }

    public boolean isStealthDisadvantage() {
        return stealthDisadvantage;
    }
}
