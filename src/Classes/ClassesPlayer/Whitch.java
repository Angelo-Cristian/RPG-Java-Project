package Classes.ClassesPlayer;

import Classes.Classes;

public class Whitch extends Player{
        private String name;
        private int HP = 70;
        private int ARM = 20;
        private int DMG = 30;

        public Whitch(String name){
            this.name = name;
        }

        @Override
        public int getHP(){
            return HP;
        }

        @Override
        public int getARM(){
            return ARM;
        }

        @Override
        public int getDMG(){return DMG;}

        @Override
        public void setHP(int HP){this.HP = HP;}

        @Override
        public void setARM(int ARM){this.ARM = ARM;}

        @Override
        public void ability1(Classes player, Classes enemy){
            DMG = 100;
            enemy.setHP(enemy.takeDamage(player, enemy));
        }

        @Override
        public void ability2(Classes player, Classes enemy){
            DMG = 7;
            enemy.setHP(enemy.takeDamage(player, enemy));
        }

        @Override
        public void ability3(Classes player, Classes enemy){
            DMG = 5;
            enemy.setHP(enemy.takeDamage(player, enemy));
        }

        @Override
        public void pasivAbility() {

        }

        @Override
        public String toString(){;
            return name + ": HP-" + getHP() + " ARM-" + getARM() + "\nABILITY 1: MATURA ZBURATOARE - 12 DMG(100 DMG PT. TEST)\nABILITY 2: RAS DE BABA MALEFICA - 7 DMG\nABILITY 3: OALA CU VRAJI - 5 DMG";
        }
}
