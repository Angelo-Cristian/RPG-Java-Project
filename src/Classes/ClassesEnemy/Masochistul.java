package Classes.ClassesEnemy;

import Classes.Classes;
import Classes.ClassesPlayer.*;
import DataBase.SavedData;

public class Masochistul extends Enemy{
    private String name = "Masochistul";
    private int HP = 130;
    private int ARM = 60;
    private int DMG;

    @Override
    public int getHP(){return HP;}

    @Override
    public int getARM(){return ARM;}

    @Override
    public int getDMG(){return DMG;}

    @Override
    public String getName(){return name;}

    @Override
    public void setHP(int HP){this.HP = HP;}

    @Override
    public void setARM(int ARM){this.ARM = ARM;}

    @Override
    public void ability1(Classes player, Classes enemy){
        DMG = 10;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void ability2(Classes player, Classes enemy){
        DMG = 30;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }
    @Override
    public void ability3(Classes player, Classes enemy){
        DMG = 40;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void pasivAbility(){

    }

    @Override
    public String toString(){;
        return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: MAI DA, TE ROG - 10 DMG\nABILITY 2: DE CE TE-AI OPRIT? - 30 DMG\nABILITY 3: STAI SA MAI DAU SI EU - 40 DMG";
    }
}
