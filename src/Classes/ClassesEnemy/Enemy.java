package Classes.ClassesEnemy;

import Classes.Classes;
import DataBase.GameData;
import DataBase.SavedData;

import java.util.Random;
import java.util.Scanner;

public abstract class Enemy extends Classes {
    //returneaza numele inamicului curent
    public abstract String getName();

    //verifica daca mai este loc in vector pt. a adauga inamici
    private static boolean verif(boolean[] vector){
        for(int i = 0; i < 3; i++){
            if(!vector[i]){
                return false;
            }
        }
        return true;
    }

    //se face random un vector cu inamici
    public static Enemy[] chooseEnemy(){
        Enemy[] enemies = new Enemy[3];

        Enemy[] existentEnemies = new Enemy[3];
        existentEnemies[0] = new Gigel();
        existentEnemies[1] = new Masochistul();
        existentEnemies[2] = new Vrajeala();

        boolean[] randomIndex = new boolean[3];
        int cnt = 0;

        Random rand = new Random();

        int index;

        while(!verif(randomIndex)){
            index = rand.nextInt(3);
            if(!randomIndex[index]){
                enemies[cnt++] = existentEnemies[index];
                randomIndex[index] = true;
            }
        }

        return enemies;
    }

    //se alege random ce abilitate va folosi inamicul
    public static void abilityMenu(Classes character, Classes theEnemy){
        int option;
        Random rand = new Random();

        option = rand.nextInt(3) + 1;

        switch (option) {
            case 1: {
                SavedData.enemies[SavedData.level].ability1(character, theEnemy);
                break;
            }
            case 2: {
                SavedData.enemies[SavedData.level].ability2(character, theEnemy);
                break;
            }
            case 3: {
                SavedData.enemies[SavedData.level].ability3(character, theEnemy);
                break;
            }
            default: {
                System.out.println("SORRY, THIS IS NOT AN OPTION. TRY AGAIN!");
                break;
            }
        }
    }
}
