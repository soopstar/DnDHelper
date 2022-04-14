package soop;

import java.util.ArrayList;

public class Character {
    private String name;
    private int level;
    private String race;
    private String background;
    private String align;
    private String charClass;
    private int hitDice;

    // Stats
    private int hp;
    private int hpMax;
    private int hpTemp;
    private int speedWalk;
    private int speedFly;
    private int armour;
    private int init;
    
    // Character Stats
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    // Modifiers for character stats
    private int strMod;
    private int dexMod;
    private int conMod;
    private int intMod;
    private int wisMod;
    private int chaMod;

    // Skills
    private int[] skills = new int[18];
    private int prof;

    // Inventory
    private Item equipped;
    private ArrayList<Item> inventory;

    // Status Effects
    private ArrayList<String> status;
    private boolean isKO = false;
    private boolean isDead = false;

    // Single use moves, for example, Extra Attack

    // Stat getters
    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    // public String getRace() {
    //     return this.race;
    // }

    // public String getBackground() {
    //     return this.background;
    // }

    // public String getAlignment() {
    //     return this.align;
    // }

    public String getCharClass() {
        return this.charClass;
    }

    // public int getHitDice() {
    //     return this.hitDice;
    // }

    public int getHP() {
        return this.hp;
    }

    public void takeDamage(int damage) {
        if (userRespUtils.askQuestionYN("Does the roll hit your armour class?", true)) {
            if (this.hpTemp > 0) {
                damage -= this.hpTemp;
            }
    
            if (damage > 0) {
                this.hp -= damage;
            }

            if (this.hp <= 0) {
                if (Math.abs(this.hp) > (0.5 * this.hpMax)) {
                    this.isDead = true;
                } else {
                    this.isKO = true;
                }
            }
        }
    }

    public void incrementHP(int health) {
        this.hp += health;

        if (this.hp > this.hpMax) {
            this.hp = this.hpMax;
        }
    }

    public void setHP(int health) {
        this.hp = health;
    }

    // public int getMaxHP() {
    //     return this.hpMax;
    // }

    // public int getTempHP() {
    //     return this.hpTemp;
    // }

    // public int getSpeed() {
    //     return this.speed;
    // }

    // public int getArmourClass() {
    //     return this.armour;
    // }

    // public int getInitialisation() {
    //     return this.init;
    // }

    // public int getSTR() {
    //     return this.strength;
    // }

    // public int 

    // Dice rolling

    // Attacks

    // Spells

    @Override
    public String toString() {
        final String[] infoFull = {
            "Name: " + this.name,
            "Level " + this.level + " " + this.charClass,
            "Race: " + this.race,
            "Background: " + this.background,
            "Alignment: " + this.align,
            "HP: " + this.hp + "/" + this.hpMax
            // TODO: Add other stats
        };

        String info = "";

        for (String s : infoFull) {
            info += s;

            if (s.startsWith("HP: ") && this.hpTemp > 0) {
                info += " (" + "+" + this.hpTemp + ")";
            }

            info += "\n";
        }

        return info;
    }
}
