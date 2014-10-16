package Main.Menu;

import Main.DataModels.Sets;
import Main.SetParam;
import Main.Utils;

/**
 * Created by Denis on 15.10.2014.
 */
public class SetMenu extends BaseMenu {
    @Override
    public void printMenu() {
        Utils.writeString("Выберите кол-во раундов(не больше 20):");
        SetParam.setCountOfRounds();
        Utils.writeEnter();
        Utils.writeString("Выберите уровень сложности игры:");
        Utils.writeString("1 - Легкая");
        Utils.writeString("2 - Средняя");
        Utils.writeString("3 - Сложная");
        getValue();
        Utils.writeEnter();
        SetParam.setParam();
        new GameMenu().printMenu();
    }

    @Override
    protected boolean select(int i) {
        switch (i) {
            case 1:
                SetParam.setDifficulty(Sets.DIFF.diff_easy);
                return true;
            case 2:
                SetParam.setDifficulty(Sets.DIFF.diff_med);
                return true;
            case 3:
                SetParam.setDifficulty(Sets.DIFF.diff_hard);
                return true;
            default:
                return false;
        }
    }
}
