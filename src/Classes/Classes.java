package Classes;

import Classes.ClassesPlayer.*;
import Classes.ClassesEnemy.*;
import java.util.Scanner;

public abstract class Classes {
    //abilitatile claselor
    public abstract void ability1(Classes player, Classes enemy);
    public abstract void ability2(Classes player, Classes enemy);
    public abstract void ability3(Classes player, Classes enemy);
    public abstract void pasivAbility();

    //getare si setare
    public abstract int getHP();
    public abstract int getARM();
    public abstract int getDMG();
    public abstract void setHP(int hp);
    public abstract void setARM(int arm);

    //indispensabilul toString
    public abstract String toString();

    //functii pentru partea de gameplay
    public int takeDamage(Classes character, Classes theEnemy){
        int DMG = character.getDMG();
        int HP = theEnemy.getHP();
        int ARM = theEnemy.getARM();

        if(DMG - ARM < 0){
            theEnemy.setARM(ARM - DMG);
            DMG = 0;
        }
        else{
            DMG -= ARM;
            theEnemy.setARM(0);
        }

        return HP -= DMG;
    }
    public int Healing(int HP, int heal){
        return HP += heal;
    }
    public boolean isAlive(int HP){
        return HP > 0;
    };

    //sistem de atac
    public static void attack(Classes player, Classes enemy, boolean playerAttacks){
        if(playerAttacks){
            System.out.println("YOU ATTACK");
            Player.abilityMenu(player, enemy);
            System.out.println("You've dealt " + player.getDMG() + " damage.");
        }
        else{
            System.out.println("THE ENEMY ATTACK");
            Enemy.abilityMenu(enemy, player);
            System.out.println("The enemy dealt " + enemy.getDMG() + " damage.");
        }
    }
}
