package Main.Game;

/**
 * Created by Denis on 05.10.2014.
 */
public class MultyTableOfRecords extends TableOfRecords {

    @Override
    public void printMenu(double t) {
        table_path = "MultyTable.txt";
        super.printMenu(t);
    }
}
