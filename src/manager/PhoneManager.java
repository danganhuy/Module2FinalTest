package manager;

import phone.Phone;

import java.util.ArrayList;
import java.util.List;

public class PhoneManager {
    private static int idCounter = 0;
    private static List<Phone> phones;

    public static void createInstance(List<Phone> phones) {
        PhoneManager.phones = phones;
        idCounter = phones.size();
    }
    public static List<Phone> getPhones() {
        return phones;
    }

    public static int createId() {
        return idCounter;
    }

    public static void addPhone(Phone phone) {
        phones.add(phone);
        idCounter ++;
    }

    public static void removePhone(Phone phone) {
        phones.remove(phone);
        for (int i = 0; i < phones.size(); i++) {
            phones.get(i).setId(i);
        }
        idCounter --;
    }

    public static Phone findPhoneById(int id) {
        for (Phone phone : phones) {
            if (phone.getId() == id) {
                return phone;
            }
        }
        return null;
    }
}
