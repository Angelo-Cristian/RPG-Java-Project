package Game;

import Classes.Classes;
import Classes.ClassesPlayer.Player;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    //partea de batalie
    public void clashing(Classes player, Classes enemy) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int roundChosser;
        int boundForPlayerChanceToAttack = 49;
        boolean playerAttacks;

        while (player.isAlive(player.getHP()) && enemy.isAlive(enemy.getHP())) {
            int option = 0;

            roundChosser = rand.nextInt(100);
            playerAttacks = (roundChosser <= boundForPlayerChanceToAttack);

            Classes.attack(player, enemy, playerAttacks);
        }
    }
}
