package Classes.ClassesPlayer;

import Classes.Classes;

public class Golem extends Player{
    //staturile player-ului
    private String name;
    private int HP = 150;
    private int ARM = 100;
    private int DMG = 0;

    public Golem(String name){
        this.name = name;
    }

    @Override
    public int getHP(){
        return HP;
    }

    @Override
    public int getARM(){return ARM;}

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
        DMG = 5;
        enemy.setHP(enemy.takeDamage(player, enemy));
    }
    @Override
    public void ability3(Classes player, Classes enemy){
        DMG = 7;
        enemy.setHP(enemy.takeDamage(player, enemy));
    }

    @Override
    public void pasivAbility(){

    }

    @Override
    public String toString(){;
        return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: SARITURA MASIVA - 17 DMG(100 DMG PT. TEST)\nABILITY 2: CAP DE BOLOVAN - 5 DMG\nABILITY 3: PRIVIRE FURIOASA - 7 DMG";
    }
}
