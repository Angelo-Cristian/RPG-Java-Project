package Classes.ClassesPlayer;

import Classes.Classes;
import java.util.Scanner;
import DataBase.SavedData;

public abstract class Player extends Classes {
    //player-ul poate sa renunte
    public static void commitSuicide(Classes player){
        player.setHP(0);
    }

    //shop pt. player
    //public void buyItems(Items item) {}

    //selectarea clasei cu care vrei sa joci
    public static Player chooseClass(String name){
        Scanner sc = new Scanner(System.in);
        int option = 0;

        while(option < 1 || option > 3){
            System.out.println("\nCHOSE YOUR CHARACTER:\n1. KNIGHT - MELEE\n2. GOLEM - TANK\n3. WHITCH - MAGE");
            System.out.print("THE OPTION IS: ");
            option = sc.nextInt();

            switch(option){
                case 1:{
                    System.out.println("KNIGHT: AT YOU SERVICE, MY KING (YOU CHOOSED THE KNIGHT)\n");
                    SavedData.playerClass = 1;

                    return new Knight(name);
                }
                case 2:{
                    System.out.println("GOLEM: GOLEEEEEEM (YOU CHOOSED THE GOLEM)\n");
                    SavedData.playerClass = 2;

                    return new Golem(name);
                }
                case 3:{
                    System.out.println("WHITCH: HEHEHEHEEEE (YOU CHOOSED THE WHITCH)\n");
                    SavedData.playerClass = 3;

                    return new Whitch(name);
                }
                default:{
                    System.out.println("\nSORRY, THIS IS NOT AN OPTION. TRY AGAIN!\n");
                    break;
                }
            }
        }
        return null;
    }

    //selectarea abilitatii pe care vrei s-o folosesti
    public static void abilityMenu(Classes character, Classes theEnemy){
        int option = 0;
        Scanner sc = new Scanner(System.in);

        while(option < 1 || option > 3){
            System.out.println("\nCHOSE YOUR ABILITY:");
            System.out.println(character.toString());
            System.out.print("THE OPTION IS: ");
            option = sc.nextInt();
            System.out.println();

            switch(option){
                case 1:{
                    character.ability1(character, theEnemy);
                    break;
                }
                case 2:{
                    character.ability2(character, theEnemy);
                    break;
                }
                case 3:{
                    character.ability3(character, theEnemy);
                    break;
                }
                default:{
                    System.out.println("SORRY, THIS IS NOT AN OPTION. TRY AGAIN!");
                    break;
                }
            }
        }
    }
}
