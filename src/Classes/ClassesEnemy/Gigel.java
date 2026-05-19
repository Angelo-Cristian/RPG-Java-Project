package Classes.ClassesEnemy;

import Classes.Classes;
import DataBase.SavedData;

public class Gigel extends Enemy{
    private String name = "Gigel";
    private int HP = 90;
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
        DMG = 4;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void ability2(Classes player, Classes enemy){
        DMG = 13;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }
    @Override
    public void ability3(Classes player, Classes enemy){
        DMG = 7;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void pasivAbility(){

    }

    @Override
    public String toString(){;
        return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: CIORDALES MAGHIARES - 4 DMG\nABILITY 2: ATAC DE LA SPATE - 13 DMG\nABILITY 3: ATAC EMOTIONAL - 7 DMG";
    }
}
