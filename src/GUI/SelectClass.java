package GUI;

import Classes.ClassesPlayer.*;
import Classes.ClassesEnemy.*;
import Classes.Classes;
import DataBase.GameData;
import DataBase.SavedData;
import Game.GameLogic;

import javax.swing.*;

public class SelectClass {
    private JButton button1;
    public JPanel panel2;
    private JButton button2;
    private JButton button3;
    private JLabel classLabel;

    public JPanel getPanel(){
        return panel2;
    }

    SelectClass(JFrame frame, JPanel beginning) {
        button1.addActionListener(e1->{
            int option = JOptionPane.showConfirmDialog(null ," Are you sure you want to become the knight?", " Choose class", JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, " KNIGHT: AT YOU SERVICE, MY KING (YOU CHOOSED THE KNIGHT)", " Knight", JOptionPane.INFORMATION_MESSAGE);

                SavedData.playerClass = 1;

                RPG_Master master = new RPG_Master(frame, beginning);

                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        button2.addActionListener(e2->{
            int option = JOptionPane.showConfirmDialog(null ," Are you sure you want to become the Golem?", " Choose class", JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, " GOLEM: GOLEEEEEEM (YOU CHOOSED THE GOLEM)", " Golem", JOptionPane.INFORMATION_MESSAGE);

                SavedData.playerClass = 2;

                RPG_Master master = new RPG_Master(frame, beginning);

                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });

        button3.addActionListener(e3->{
            int option = JOptionPane.showConfirmDialog(null ," Are you sure you want to become the Whitch?", " Choose class", JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, " WHITCH: HEHEHEHEEEE (YOU CHOOSED THE WHITCH)", " Whitch", JOptionPane.INFORMATION_MESSAGE);

                SavedData.playerClass = 3;

                RPG_Master master = new RPG_Master(frame, beginning);

                frame.setContentPane(master.getPanel());
                frame.revalidate();
                frame.repaint();
            }
        });
    }
}
