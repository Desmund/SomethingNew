package Main.Menu;

import Main.Game.*;
import Main.Game.SetParam;
import Main.Utils;

/**
 * Created by Denis on 30.09.2014.
 */
public class GameMenu extends BaseMenu{
    @Override
    public void printMenu() {
        Utils.writeString("1 - Начать одиночную игру");
        Utils.writeString("2 - Начать мультиплеерную игру");
        Utils.writeString("3 - Настройки игры");
        Utils.writeString("4 - Просмотреть таблицу рекордов");
        super.printMenu();
        getValue();
    }

    @Override
    protected boolean select(int i) {
        switch (i) {
            case 1:
                new AlonePlay().printMenu();
                return true;
            case 2:
                new MultyPlay().printMenu();
                return true;
            case 3:
                new SetParam().printMenu();
                return true;
            case 4:
                //todo создать класс для чтения записей из файла и вывода турнирной таблицы
                new GameMenu().printMenu();
                return true;
            default:
                return super.select(i);
        }
    }
}
