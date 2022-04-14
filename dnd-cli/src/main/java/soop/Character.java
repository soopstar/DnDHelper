package soop;

import java.util.ArrayList;

public class Character {
    private final String name;
    private final int level;
    private final String race;
    private final String background;
    private final String align;
    private final String charClass;
    private final int hitDice;

    // Stats
    private int hp;
    private final int hpMax;
    private int hpTemp;
    private int speed;
    private int armour;
    private final int init;
    
    // Character Stats
    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    private final int strMod;
    private final int dexMod;
    private final int conMod;
    private final int intMod;
    private final int wisMod;
    private final int chaMod;

    // Skills
    private final int[] skills = new int[18];

    // Inventory
    private Item equipped;
    private ArrayList<Item> inventory;

    // Status Effects
    private ArrayList<String> status;
}
