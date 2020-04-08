package com.abryant;

import java.util.HashMap;
import java.util.List;

import static com.abryant.Status.CONSCIOUS;

public class PlayerCharacterBuilder {
    private String characterName;
    private int level = 1;
    private int experiencePoints = 0;
    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;
    private int proficiencyBonus = 2;
    private List<Attribute> savingThrowProficiencies;
    private List<Skill> skillProficiencies;
    private List<Weapon> weaponProficiencies;
    private int armorClass;
    private int initiative;
    private int speed;
    private int maxHitPoints;
    private int currentHitPoints;
    private int temporaryHitPoints = 0;
    private HashMap<Dice, Integer> hitDice;
    private int deathSavesSuccesses = 0;
    private int deathSavesFailures = 0;
    private Status status = CONSCIOUS;

    public PlayerCharacterBuilder setCharacterName(final String characterName) {
        this.characterName = characterName;
        return this;
    }

    public PlayerCharacterBuilder setLevel(final int level) {
        this.level = level;
        return this;
    }

    public PlayerCharacterBuilder setExperiencePoints(final int experiencePoints) {
        this.experiencePoints = experiencePoints;
        return this;
    }

    public PlayerCharacterBuilder setStrengthScore(final int strengthScore) {
        this.strengthScore = strengthScore;
        return this;
    }

    public PlayerCharacterBuilder setDexterityScore(final int dexterityScore) {
        this.dexterityScore = dexterityScore;
        return this;
    }

    public PlayerCharacterBuilder setConstitutionScore(final int constitutionScore) {
        this.constitutionScore = constitutionScore;
        return this;
    }

    public PlayerCharacterBuilder setIntelligenceScore(final int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
        return this;
    }

    public PlayerCharacterBuilder setWisdomScore(final int wisdomScore) {
        this.wisdomScore = wisdomScore;
        return this;
    }

    public PlayerCharacterBuilder setCharismaScore(final int charismaScore) {
        this.charismaScore = charismaScore;
        return this;
    }

    public PlayerCharacterBuilder setProficiencyBonus(final int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
        return this;
    }

    public PlayerCharacterBuilder setSavingThrowProficiencies(final List<Attribute> savingThrowProficiencies) {
        this.savingThrowProficiencies = savingThrowProficiencies;
        return this;
    }

    public PlayerCharacterBuilder setSkillProficiencies(final List<Skill> skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
        return this;
    }

    public PlayerCharacterBuilder setWeaponProficiencies(final List<Weapon> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
        return this;
    }

    public PlayerCharacterBuilder setArmorClass(final int armorClass) {
        this.armorClass = armorClass;
        return this;
    }

    public PlayerCharacterBuilder setInitiative(final int initiative) {
        this.initiative = initiative;
        return this;
    }

    public PlayerCharacterBuilder setSpeed(final int speed) {
        this.speed = speed;
        return this;
    }

    public PlayerCharacterBuilder setMaxHitPoints(final int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
        return this;
    }

    public PlayerCharacterBuilder setCurrentHitPoints(final int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
        return this;
    }

    public PlayerCharacterBuilder setTemporaryHitPoints(final int temporaryHitPoints) {
        this.temporaryHitPoints = temporaryHitPoints;
        return this;
    }

    public PlayerCharacterBuilder setHitDice(final HashMap<Dice, Integer> hitDice) {
        this.hitDice = hitDice;
        return this;
    }

    public PlayerCharacterBuilder setDeathSavesSuccesses(final int deathSavesSuccesses) {
        this.deathSavesSuccesses = deathSavesSuccesses;
        return this;
    }

    public PlayerCharacterBuilder setDeathSavesFailures(final int deathSavesFailures) {
        this.deathSavesFailures = deathSavesFailures;
        return this;
    }

    public PlayerCharacterBuilder setStatus(final Status status) {
        this.status = status;
        return this;
    }

    public PlayerCharacter createPlayerCharacter() {
        return new PlayerCharacter(characterName,
                                   level,
                                   experiencePoints,
                                   strengthScore,
                                   dexterityScore,
                                   constitutionScore,
                                   intelligenceScore,
                                   wisdomScore,
                                   charismaScore,
                                   proficiencyBonus,
                                   savingThrowProficiencies,
                                   skillProficiencies,
                                   weaponProficiencies,
                                   armorClass,
                                   initiative,
                                   speed,
                                   maxHitPoints,
                                   currentHitPoints,
                                   temporaryHitPoints,
                                   hitDice,
                                   deathSavesSuccesses,
                                   deathSavesFailures,
                                   status);
    }
}
