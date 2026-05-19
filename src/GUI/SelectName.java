package GUI;

import Classes.ClassesEnemy.Enemy;
import DataBase.GameData;
import DataBase.SavedData;

import javax.swing.*;
import java.awt.*;

public class SelectName {
    private JPanel panel1;
    private JButton enterButton;
    private JTextField textField1;
    private JLabel whatName;
    private JFrame frame;
    private SelectClass selectClass;

    private void goNext(){
        SavedData.name = textField1.getText();

        textField1.setText("");

        if(SavedData.isSaved){
            RPG_Master master = new RPG_Master(frame, panel1);
            frame.setContentPane(master.getPanel());
        }
        else{
            selectClass = new SelectClass(frame, panel1);
            frame.setContentPane(selectClass.getPanel());
        }

        frame.revalidate() ;
        frame.repaint() ;
    }

    public SelectName() {
        frame = new JFrame("RPG Masters");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        enterButton.addActionListener(e->{
            if(textField1.getText().equals("")){
                JOptionPane.showMessageDialog(null, " Off, you have no name? How sad! Go back and write one tho. Use your creativity.", " Nameless specimen detected ", JOptionPane.ERROR_MESSAGE);
            }
            else{
                int option = JOptionPane.showConfirmDialog(null ," Are you sure this is your name?", " Choose name", JOptionPane.YES_NO_OPTION);

                if(option == JOptionPane.YES_OPTION){
                    GameData gameData = new GameData(textField1.getText());

                    if(gameData.isSaved){
                        int option2 = JOptionPane.showConfirmDialog(null ," This name already exists. Do you want to continue with it?", " Existent name", JOptionPane.YES_NO_OPTION);

                        if(option2 == JOptionPane.YES_OPTION){
                            gameData.deleteRow(textField1.getText());
                            goNext();
                        }
                        else{
                            textField1.setText("");
                        }
                    }
                    else{
                        gameData.deleteRow(textField1.getText());
                        goNext();
                    }
                }
                else{
                    textField1.setText("");
                }
            }
        });

        frame.setContentPane (panel1) ;
        frame.setSize (420, 220) ;
        frame.setLocationRelativeTo (null) ;
        frame.setVisible (true) ;

    }
}
