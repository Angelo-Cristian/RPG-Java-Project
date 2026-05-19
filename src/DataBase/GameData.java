package DataBase;

import java.sql.*;
import Classes.ClassesEnemy.Enemy;
import Classes.ClassesEnemy.Gigel;
import Classes.ClassesEnemy.Masochistul;
import Classes.ClassesEnemy.Vrajeala;
import Classes.ClassesPlayer.*;

public class GameData {
    Connection connection;
    public boolean isSaved = false;

    public GameData(String name) {
        try{
            String url = "jdbc:sqlite:gamedata.db";
            this.connection = DriverManager.getConnection(url);

            SavedData.name = name;

            if(verifyExistingName(name)){
                getSavedData();
                SavedData.isSaved = isSaved = true;
            }

            if(!isSaved){
                PreparedStatement pstmt = connection.prepareStatement("INSERT INTO game_table (name) VALUES (?);");

                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
    }

    public boolean verifyExistingName(String name){
        boolean exists = false;
        try{
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT name FROM game_table;");

            while(results.next()){
                if(results.getString("name").equals(name)){
                    exists = true;
                }
            }

        }catch(SQLException e){
            System.out.println("ERROR CONNECTION TO DATA BASE 2");
        }

        return exists;
    }

    public void getSavedData(){
        try {
            Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM game_table;");

            while (results.next()) {
                if (SavedData.name.equals(results.getString("name"))) {
                    SavedData.level = results.getInt("level");
                    SavedData.enemy1 = results.getInt("enemy1");
                    SavedData.enemy2 = results.getInt("enemy2");
                    SavedData.enemy3 = results.getInt("enemy3");
                    SavedData.playerClass = results.getInt("player_class");

                    break;
                }
            }
        }catch(SQLException e){
            System.out.println("ERROR CONNECTION TO DATA BASE 3");
        }
    }

    public void deleteRow(String name){
        try{
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM game_table WHERE name = ?;");

            pstmt.setString(1, name);

            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public Player getSavedPlayerClass(){
        switch(SavedData.playerClass){
            case 1:{
                return new Knight(SavedData.name);
            }
            case 2:{
                return new Whitch(SavedData.name);
            }
            case 3:{
                return new Golem(SavedData.name);
            }
            default:{
                break;
            }
        }

        return null;
    }

    public void savePlayerClass(){
        try{
            PreparedStatement pstmt = connection.prepareStatement("UPDATE game_table SET player_class = ? WHERE name = ?;");

            pstmt.setInt(1, SavedData.playerClass);
            pstmt.setString(2, SavedData.name);
            pstmt.executeUpdate();

        }catch(SQLException e){
            System.out.println("ERROR CONNECTION TO DATA BASE 4");
        }
    }

    public Enemy[] getSavedEnemies(){
        Enemy[] enemies = new Enemy[3];

        for(int i = 0; i < 3; ++i){
            switch(i){
                case 0:{
                    if(SavedData.enemy1 == 0){
                        enemies[i] = new Gigel();
                    }
                    else if(SavedData.enemy1 == 1){
                        enemies[i] = new Masochistul();
                    }
                    else if(SavedData.enemy1 == 2){
                        enemies[i] = new Vrajeala();
                    }

                    break;
                }
                case 1:{
                    if(SavedData.enemy2 == 0){
                        enemies[i] = new Gigel();
                    }
                    else if(SavedData.enemy2 == 1){
                        enemies[i] = new Masochistul();
                    }
                    else if(SavedData.enemy2 == 2){
                        enemies[i] = new Vrajeala();
                    }

                    break;
                }
                case 2:{
                    if(SavedData.enemy3 == 0){
                        enemies[i] = new Gigel();
                    }
                    else if(SavedData.enemy3 == 1){
                        enemies[i] = new Masochistul();
                    }
                    else if(SavedData.enemy3 == 2){
                        enemies[i] = new Vrajeala();
                    }

                    break;
                }
            }
        }

        return enemies;
    }

    public void saveEnemies(Enemy[] enemies){
        try{
            int enemy = 0;

            for(int i = 0; i < 3; ++i){
                if(enemies[i].getName().equals("Gigel")){
                    enemy = 0;
                }
                else if(enemies[i].getName().equals("Masochistul")){
                    enemy = 1;
                }
                else if(enemies[i].getName().equals("Vrajeala")){
                    enemy = 2;
                }

                switch(i){
                    case 0:{
                        PreparedStatement pstmt = connection.prepareStatement("UPDATE game_table SET enemy1 = ? WHERE name = ?;");
                        pstmt.setInt(1, enemy);
                        pstmt.setString(2, SavedData.name);

                        pstmt.executeUpdate();

                        break;
                    }
                    case 1:{

                        PreparedStatement pstmt = connection.prepareStatement("UPDATE game_table SET enemy2 = ? WHERE name = ?;");
                        pstmt.setInt(1, enemy);
                        pstmt.setString(2, SavedData.name);

                        pstmt.executeUpdate();

                        break;
                    }
                    case 2:{
                        PreparedStatement pstmt = connection.prepareStatement("UPDATE game_table SET enemy3 = ? WHERE name = ?;");
                        pstmt.setInt(1, enemy);
                        pstmt.setString(2, SavedData.name);

                        pstmt.executeUpdate();

                        break;
                    }
                    default:{
                        break;
                    }
                }
            }

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    public void saveLevel(int level){
        try{
            PreparedStatement pstmt = connection.prepareStatement("UPDATE game_table SET level = ? WHERE name = ?;");
            pstmt.setInt(1, level);
            pstmt.setString(2, SavedData.name);

            pstmt.executeUpdate();

        }catch(SQLException e){
            System.out.println("ERROR CONNECTION TO DATA BASE 6");
        }
    }
}