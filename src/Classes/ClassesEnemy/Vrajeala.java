package Classes.ClassesEnemy;

import Classes.Classes;
import DataBase.SavedData;

public class Vrajeala extends Enemy{
    private String name = "Vrajeala";
    private int HP = 70;
    private int ARM = 40;
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
        DMG = 20;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void ability2(Classes player, Classes enemy){
        DMG = 14;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }
    @Override
    public void ability3(Classes player, Classes enemy){
        DMG = 16;
        SavedData.player.setHP(SavedData.player.takeDamage(SavedData.enemies[SavedData.level], SavedData.player));
    }

    @Override
    public void pasivAbility(){

    }

    @Override
    public String toString(){;
        return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: NU TE-AS RANI NICI-O DATA - 20 DMG\nABILITY 2: CE-I IN SPATELE TAU? - 14 DMG\nABILITY 3: DIN GRESEALA SEFU - 16 DMG";
    }
}
