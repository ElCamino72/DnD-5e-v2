package com.abryant;

import static com.abryant.Attribute.CHARISMA;
import static com.abryant.Attribute.DEXTERITY;
import static com.abryant.Attribute.INTELLIGENCE;
import static com.abryant.Attribute.STRENGTH;
import static com.abryant.Attribute.WISDOM;

public enum Skill {
    ACROBATICS(DEXTERITY), ANIMAL_HANDLING(WISDOM), ARCANA(INTELLIGENCE), ATHLETICS(STRENGTH),
    DECEPTION(CHARISMA), HISTORY(INTELLIGENCE), INSIGHT(WISDOM), INTIMIDATION(CHARISMA),
    INVESTIGATION(INTELLIGENCE), MEDICINE(WISDOM), NATURE(INTELLIGENCE), PERCEPTION(WISDOM),
    PERFORMANCE(CHARISMA), PERSUASION(CHARISMA), RELIGION(INTELLIGENCE), SLEIGHT_OF_HAND(DEXTERITY),
    STEALTH(DEXTERITY), SURVIVAL(WISDOM);

    private final Attribute attribute;

    Skill(final Attribute attribute) {
        this.attribute = attribute;
    }

    public Attribute getAttribute() {
        return attribute;
    }
}
