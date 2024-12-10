package file;

import manager.PhoneManager;
import phone.ImportedPhone;
import phone.OfficalPhone;
import phone.Phone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "data\\phone.csv";
    private static final String VALUE_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = "\n";

    public static void saveData() {
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILE_PATH);

            for (Phone phone : PhoneManager.getPhones()) {
                fw.append(phone + LINE_SEPARATOR);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void loadData() {
        BufferedReader br = null;

        try {
            List<Phone> phones = new ArrayList<>();
            br = new BufferedReader(new FileReader(FILE_PATH));

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(VALUE_SEPARATOR);
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int quantity = Integer.parseInt(data[3]);
                String producer = data[4];

                try {
                    int warrantyDuration = Integer.parseInt(data[5]);
                    String warrantyCoverage = data[6];
                    phones.add(new OfficalPhone(id,name,price,quantity,producer,
                            warrantyDuration,warrantyCoverage));
                } catch (NumberFormatException e) {
                    String country = data[5];
                    String condition = data[6];
                    phones.add(new ImportedPhone(id,name,price,quantity,producer,
                            country,condition));
                }
            }

            PhoneManager.createInstance(phones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileHandler.loadData();
        for (Phone phone : PhoneManager.getPhones()) {
            System.out.println(phone);
        }
        FileHandler.saveData();
    }
}
