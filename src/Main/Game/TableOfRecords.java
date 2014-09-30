package Main.Game;

import Main.Menu.BaseMenu;
import Main.Menu.GameMenu;
import Main.Utils;

/**
 * Created by Denis on 30.09.2014.
 */
public class TableOfRecords extends BaseMenu {
    @Override
    public void printMenu() {
        Utils.writeString("Записать ваш результат в таблицу рекордов?");
        Utils.writeString("1 - Да");
        Utils.writeString("2 - Нет");
        getValue();
    }

    @Override
    protected boolean select(int i) {
        switch (i){
            case 1:
                writeToFile();
                return true;
            case 2:
                new GameMenu().printMenu();
                return true;
        }
        return false;
    }

    private void writeToFile(){
        //todo заполнить таблицу рекордов
        //todo работа с json строкой
        new GameMenu().printMenu();
    }
}
