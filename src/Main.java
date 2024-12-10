import file.FileHandler;
import manager.PhoneManager;
import view.PhoneManagerView;

public class Main {
    public static void main(String[] args) {
        FileHandler.loadData();
        PhoneManagerView view = new PhoneManagerView();
        view.index();
    }
}
