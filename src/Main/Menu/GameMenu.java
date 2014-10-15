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
        //todo рефакторинг!
        SetParam.getParam();
        Utils.writeString("1 - Начать одиночную игру");
        Utils.writeString("2 - Начать мультиплеерную игру");
        Utils.writeString("3 - Настройки игры");
        Utils.writeString("4 - Просмотреть таблицу рекордов");
        super.printMenu();
        getValue();
    }

    @Override
    protected boolean select(int i) {
        Utils.writeEnter();
        switch (i) {
            case 1:
                new AlonePlay().printMenu();
                return true;
            case 2:
                new MultyPlay().printMenu();
                return true;
            case 3:
                new SetMenu().printMenu();
                return true;
            case 4:
                tableOfRecords();
                return true;
            default:
                return super.select(i);
        }
    }

    private void tableOfRecords(){
        Utils.writeString("Выберите таблицу:");
        Utils.writeString("1 - одиночная");
        Utils.writeString("2 - мультиплеерная");
        int val = 0;
            while(val == 0) {
                try {
                    val = Utils.readInteger();
                    if((val<1)||(val>2)){
                        val = 0;
                        Utils.writeString("Введите 1 или 2!");
                    }
                    else break;
                }catch (Exception e){
                    val = 0;
                    Utils.writeString("Ошибка ввода числа!");
                }
            }
        switch (val){
            case 1:
                new TableOfRecords().printMenu(true);
            case 2:
                new TableOfRecords().printMenu(false);
        }
    }
}
