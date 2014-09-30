package Main.Menu;

import Main.Utils;

import java.io.IOException;

/**
 * Created by Denis on 30.09.2014.
 */

public abstract class BaseMenu {
    protected void printMenu(){
        Utils.writeString("0 - Выход из игры");
    }

    protected boolean select(int i){
        switch (i) {
            case 0:
                System.exit(0);
                return true;
        }
        return false;
    }

    protected int getValue(){
        int value = -1;
        boolean hasValue = false;
        while(!hasValue){
            try {
                value = Utils.readInteger();
                hasValue = select(value);
                if(!hasValue)
                    Utils.writeString("Введено не верное число!");
            }catch (Exception e){
                Utils.writeString("Ошибка при вводе целого числа!");
            }
        }
        return value;
    }
}
