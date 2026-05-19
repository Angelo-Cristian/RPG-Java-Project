package GUI;

import Classes.Classes;
import Classes.ClassesPlayer.Player;
import Classes.ClassesEnemy.*;
import DataBase.GameData;
import DataBase.SavedData;
import Game.GameLogic;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class RPG_Master {
    private JButton battleButton;
    private JPanel panel1;
    private JButton yourStatsButton;
    private JButton enemyStatsButton;
    private JButton giveUpButton;
    private JLabel labelBattle;

    public JPanel getPanel(){
        return panel1;
    }

    public void setLabel(){
        this.labelBattle.setText("Level: " + (SavedData.level + 1));
    }

    private void attack(JFrame frame, GameData gameData, JPanel beginning){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int roundChosser;
        int boundForPlayerChanceToAttack = 49;
        boolean playerAttacks;

        int option = 0;

        roundChosser = rand.nextInt(100);
        playerAttacks = (roundChosser <= boundForPlayerChanceToAttack);

        if(playerAttacks){
            PlayerAttack attack = new PlayerAttack(this, frame, gameData, beginning);

            frame.setContentPane(attack.getPanel());
            frame.revalidate();
            frame.repaint();
        }
        else{
            Enemy.abilityMenu(SavedData.enemies[SavedData.level], SavedData.player);

            if(!SavedData.player.isAlive(SavedData.player.getHP())){
                GameOver go = new GameOver(frame, beginning, gameData);

                go.setLabel("You lost!");

                frame.setContentPane(go.getPanel());
                frame.revalidate();
                frame.repaint();
            }

            JOptionPane.showMessageDialog(null, "The enemy dealt " + SavedData.enemies[SavedData.level].getDMG() + " damage.", " enemy attack ", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    RPG_Master(JFrame frame, JPanel beginning){
        GameLogic gameLogic = new GameLogic();
        GameData gameData = new GameData(SavedData.name);

        if(SavedData.level == 3){
            SavedData.level = 0;
        }

        gameData.saveLevel(SavedData.level);

        if(!gameData.isSaved){
            SavedData.enemies = Enemy.chooseEnemy();

            gameData.saveEnemies(SavedData.enemies);
        }
        else {
            SavedData.enemies = gameData.getSavedEnemies();
        }

        labelBattle.setText("Level: " + (SavedData.level + 1));

        SavedData.player = gameData.getSavedPlayerClass();
        gameData.savePlayerClass();

        battleButton.addActionListener(e->{
            attack(frame, gameData, beginning);
        });

        yourStatsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, SavedData.player.toString(), " your stats ", JOptionPane.INFORMATION_MESSAGE);
        });

        enemyStatsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, SavedData.enemies[SavedData.level].toString(), " enemy stats ", JOptionPane.INFORMATION_MESSAGE);
        });

        giveUpButton.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(null ," Are you sure you want to give up?", " Give up!", JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION){
                GameOver go = new GameOver(frame, beginning, gameData);

                go.setLabel("You commited suicide, what an honorable act, YOU WEAKLING.");

                frame.setContentPane(go.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });
    }
 }
