package GUI;

import DataBase.GameData;
import DataBase.SavedData;

import javax.swing.*;

public class PlayerAttack {
    private JPanel panel1;
    private JButton ability1Button;
    private JButton ability2Button;
    private JButton ability3Button;
    private JButton yourStatsButton;
    private JButton enemyStatsButton;

    public JPanel getPanel(){
        return panel1;
    }

    PlayerAttack(RPG_Master master, JFrame frame, GameData gameData, JPanel beginning){
        ability1Button.addActionListener(e->{
            SavedData.player.ability1(SavedData.player, SavedData.enemies[SavedData.level]);

            JOptionPane.showMessageDialog(null, "You've dealt " + SavedData.player.getDMG() + " damage.", " you attack ", JOptionPane.INFORMATION_MESSAGE);

            if(!SavedData.enemies[SavedData.level].isAlive(SavedData.enemies[SavedData.level].getHP())){
                ++SavedData.level;
                gameData.saveLevel(SavedData.level);

                if(SavedData.level == 3){
                    GameOver go = new GameOver(frame, beginning, gameData);

                    go.setLabel("You won!");

                    frame.setContentPane(go.getPanel());
                    frame.revalidate();
                    frame.repaint();
                }
            }

            if(SavedData.level < 3){
                master.setLabel();
                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        ability2Button.addActionListener(e->{
            SavedData.player.ability2(SavedData.player, SavedData.enemies[SavedData.level]);

            JOptionPane.showMessageDialog(null, "You've dealt " + SavedData.player.getDMG() + " damage.", " you attack ", JOptionPane.INFORMATION_MESSAGE);

            if(!SavedData.enemies[SavedData.level].isAlive(SavedData.enemies[SavedData.level].getHP())){
                ++SavedData.level;
                gameData.saveLevel(SavedData.level);

                if(SavedData.level == 3){
                    GameOver go = new GameOver(frame, beginning, gameData);

                    go.setLabel("You won!");

                    frame.setContentPane(go.getPanel());
                    frame.revalidate();
                    frame.repaint();
                }
            }

            if(SavedData.level < 3){
                master.setLabel();
                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        ability3Button.addActionListener(e->{
            SavedData.player.ability3(SavedData.player, SavedData.enemies[SavedData.level]);

            JOptionPane.showMessageDialog(null, "You've dealt " + SavedData.player.getDMG() + " damage.", " you attack ", JOptionPane.INFORMATION_MESSAGE);

            if(!SavedData.enemies[SavedData.level].isAlive(SavedData.enemies[SavedData.level].getHP())){
                ++SavedData.level;
                gameData.saveLevel(SavedData.level);

                if(SavedData.level == 3){
                    GameOver go = new GameOver(frame, beginning, gameData);

                    go.setLabel("You won!");

                    frame.setContentPane(go.getPanel());
                    frame.revalidate();
                    frame.repaint();
                }
            }

            if(SavedData.level < 3){
                master.setLabel();
                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        yourStatsButton.addActionListener(e->{
            JOptionPane.showMessageDialog(null, SavedData.player.toString(), " your stats ", JOptionPane.INFORMATION_MESSAGE);
        });

        enemyStatsButton.addActionListener(e->{
            JOptionPane.showMessageDialog(null, SavedData.enemies[SavedData.level].toString(), " enemy stats ", JOptionPane.INFORMATION_MESSAGE);
        });
    }
}
