package GUI;

import DataBase.GameData;
import DataBase.SavedData;

import javax.swing.*;

public class GameOver {
    private JPanel panel1;
    private JButton newGameButton;
    private JButton exitButton;
    private JLabel label1;

    JPanel getPanel(){
        return panel1;
    }

    void setLabel(String text){
        label1.setText(text);
    }

    GameOver(JFrame frame, JPanel beginning, GameData gameData) {
        newGameButton.addActionListener(e -> {
            SavedData.level = 0;
            gameData.saveLevel(SavedData.level);
            gameData.deleteRow(SavedData.name);

            SelectName selectName = new SelectName();

            frame.dispose();
        });

        exitButton.addActionListener(e -> {
           frame.dispose();
        });
    }
}
