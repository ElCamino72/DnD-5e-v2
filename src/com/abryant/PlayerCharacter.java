package com.abryant;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class PlayerCharacter {
    private String characterName;

    private int level;
    private int experiencePoints;

    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;

    private int proficiencyBonus;
    private List<Attribute> savingThrowProficiencies;
    private List<Skill> skillProficiencies;
    private List<Weapon> weaponProficiencies;
    private List<Armor> armorProficiencies;

    private int armorClass;
    private int initiative;
    private int speed;
    private int maxHitPoints;
    private int currentHitPoints;
    private int temporaryHitPoints;

    private HashMap<Dice, Integer> hitDice;
    private int deathSavesSuccesses;
    private int deathSavesFailures;
    private Status status;

    private HashMap<Item, Integer> inventory;
    private Item mainHand;
    private Item offHand;
    private Armor armor;

    public PlayerCharacter(final String characterName,
                           final int level,
                           final int experiencePoints,
                           final int strengthScore,
                           final int dexterityScore,
                           final int constitutionScore,
                           final int intelligenceScore,
                           final int wisdomScore,
                           final int charismaScore,
                           final int proficiencyBonus,
                           final List<Attribute> savingThrowProficiencies,
                           final List<Skill> skillProficiencies,
                           final List<Weapon> weaponProficiencies,
                           final int armorClass,
                           final int initiative,
                           final int speed,
                           final int maxHitPoints,
                           final int currentHitPoints,
                           final int temporaryHitPoints,
                           final HashMap<Dice, Integer> hitDice,
                           final int deathSavesSuccesses,
                           final int deathSavesFailures,
                           final Status status) {
        this.characterName = characterName;
        this.level = level;
        this.experiencePoints = experiencePoints;
        this.strengthScore = strengthScore;
        this.dexterityScore = dexterityScore;
        this.constitutionScore = constitutionScore;
        this.intelligenceScore = intelligenceScore;
        this.wisdomScore = wisdomScore;
        this.charismaScore = charismaScore;
        this.proficiencyBonus = proficiencyBonus;
        this.savingThrowProficiencies = savingThrowProficiencies;
        this.skillProficiencies = skillProficiencies;
        this.weaponProficiencies = weaponProficiencies;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.maxHitPoints = maxHitPoints;
        this.currentHitPoints = currentHitPoints;
        this.temporaryHitPoints = temporaryHitPoints;
        this.hitDice = hitDice;
        this.deathSavesSuccesses = deathSavesSuccesses;
        this.deathSavesFailures = deathSavesFailures;
        this.status = status;
    }

    public int savingThrow(Attribute attribute) {
        int savingThrow = dieRoll() + this.getAbilityModifier(attribute);
        savingThrow += this.getSavingThrowProficiencies().contains(attribute) ? this.getProficiencyBonus() : 0;

        return savingThrow;
    }

    public int skillCheck(Skill skill) {
        int skillCheck = dieRoll() + this.getAbilityModifier(skill.getAttribute());
        skillCheck += this.getSkillProficiencies().contains(skill) ? this.getProficiencyBonus() : 0;

        return skillCheck;
    }

    public int getAbilityModifier(Attribute attribute) {
        int abilityModifier = 0;

        switch (attribute) {
            case STRENGTH:
                abilityModifier = this.getStrengthScore();
                break;
            case DEXTERITY:
                abilityModifier = this.getDexterityScore();
                break;
            case CONSTITUTION:
                abilityModifier = this.getConstitutionScore();
                break;
            case INTELLIGENCE:
                abilityModifier = this.getIntelligenceScore();
                break;
            case WISDOM:
                abilityModifier = this.getWisdomScore();
                break;
            case CHARISMA:
                abilityModifier = this.getCharismaScore();
                break;
        }

        abilityModifier = Math.floorDiv(abilityModifier - 10, 2);

        return abilityModifier;
    }

    public String deathSavingThrow() {
        if (this.getStatus() == Status.DEAD) {
            return "This character is lost, no more saving throws.";
        } else if (this.getStatus() != Status.DYING) {
            return "This character is safe for now, no saving throw needed.";
        }

        int savingThrowRoll = dieRoll();

        if (savingThrowRoll == 20) {
            deathSavesSuccesses += 2;
        } else if (savingThrowRoll >= 10) {
            deathSavesSuccesses += 1;
        } else if (savingThrowRoll == 1) {
            deathSavesFailures += 2;
        } else {
            deathSavesFailures += 1;
        }

        if (deathSavesSuccesses >= 3) {
            this.stabilize();
            return "This character is now stable.";
        } else if (deathSavesFailures >= 3) {
            this.status = Status.DEAD;
            return "This character has been lost.";
        } else {
            return "This character is still in critical condition.";
        }
    }

    public void stabilize() {
        if (this.getStatus() == Status.CONSCIOUS || this.getStatus() == Status.DEAD) {
            return;
        }

        this.status = Status.STABLE;
        this.deathSavesSuccesses = 0;
        this.deathSavesFailures = 0;
    }

    public static int dieRoll() {
        final Random random = new Random();
        return random.nextInt(20) + 1;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(final String characterName) {
        this.characterName = characterName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(final int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(final int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(final int strengthScore) {
        this.strengthScore = strengthScore;
    }

    public int getDexterityScore() {
        return dexterityScore;
    }

    public void setDexterityScore(final int dexterityScore) {
        this.dexterityScore = dexterityScore;
    }

    public int getConstitutionScore() {
        return constitutionScore;
    }

    public void setConstitutionScore(final int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(final int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public int getWisdomScore() {
        return wisdomScore;
    }

    public void setWisdomScore(final int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }

    public int getCharismaScore() {
        return charismaScore;
    }

    public void setCharismaScore(final int charismaScore) {
        this.charismaScore = charismaScore;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(final int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public List<Attribute> getSavingThrowProficiencies() {
        return savingThrowProficiencies;
    }

    public void setSavingThrowProficiencies(final List<Attribute> savingThrowProficiencies) {
        this.savingThrowProficiencies = savingThrowProficiencies;
    }

    public List<Skill> getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(final List<Skill> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public List<Weapon> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(final List<Weapon> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public List<Armor> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(final List<Armor> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(final int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(final int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(final int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(final int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getTemporaryHitPoints() {
        return temporaryHitPoints;
    }

    public void setTemporaryHitPoints(final int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
    }

    public HashMap<Dice, Integer> getHitDice() {
        return hitDice;
    }

    public void setHitDice(final HashMap<Dice, Integer> hitDice) {
        this.hitDice = hitDice;
    }

    public int getDeathSavesSuccesses() {
        return deathSavesSuccesses;
    }

    public int getDeathSavesFailures() {
        return deathSavesFailures;
    }

    public Status getStatus() {
        return status;
    }

    public HashMap<Item, Integer> getInventory() {
        return inventory;
    }

    public void setInventory(final HashMap<Item, Integer> inventory) {
        this.inventory = inventory;
    }

    public Item getMainHand() {
        return mainHand;
    }

    public void setMainHand(final Item mainHand) {
        this.mainHand = mainHand;
    }

    public Item getOffHand() {
        return offHand;
    }

    public void setOffHand(final Item offHand) {
        this.offHand = offHand;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(final Armor armor) {
        this.armor = armor;
    }
}
