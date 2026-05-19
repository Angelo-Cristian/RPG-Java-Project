package Classes.ClassesPlayer;

import Classes.Classes;

public class Knight extends Player{
    private String name;
    private int HP = 100;
    private int ARM = 50;
    private int DMG;

    public Knight(String name){
        this.name = name;
    }

    @Override
    public int getHP() {
        return HP;
    }

    @Override
    public int getARM() {
        return ARM;
    }

    @Override
    public int getDMG(){return DMG;}

    @Override
    public void setHP(int HP){this.HP = HP;}

    @Override
    public void setARM(int ARM){this.ARM = ARM;}

    @Override
    public void ability1(Classes player, Classes enemy){
        DMG = 100;
        enemy.setHP(enemy.takeDamage(player, enemy));
    }

    @Override
    public void ability2(Classes player, Classes enemy){
        DMG = 15;
        enemy.setHP(enemy.takeDamage(player, enemy));
    }

    @Override
    public void ability3(Classes player, Classes enemy){
        DMG = 13;
        enemy.setHP(enemy.takeDamage(player, enemy));
    }

    @Override
    public void pasivAbility(){

    }

    @Override
    public String toString(){;
        return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: ATAC CU SABIA(100 DMG PT. TEST) - 20 DMG\nABILITY 2: URLET DE CAVALER - 15 DMG\nABILITY 3: CHARM DE EROU - 13 DMG";
    }
}
