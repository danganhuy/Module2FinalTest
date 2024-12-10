package view;

import file.FileHandler;
import manager.PhoneManager;
import phone.ImportedPhone;
import phone.OfficalPhone;
import phone.Phone;

import java.util.Scanner;

public class PhoneManagerView {
    public void index() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("    --- Chương trình quản lý điện thoại ---");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách điện thoại");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addPhone();
                    break;
                case 2:
                    break;
                case 3:
                    displayPhoneList();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("##### Lựa chọn không hợp lệ #####");
                    break;
            }
        }
    }

    public void addPhone() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("    --- Thêm điện thoại ---");
            System.out.println("1. Thêm điện thoại xách tay");
            System.out.println("2. Thêm điện thoại chính hãng");
            System.out.println("3. Quay lại");
            System.out.println("Chọn: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("=== Thêm điện thoại xách tay ===");

                        System.out.print("Tên: ");
                        String name = scanner.next();

                        System.out.print("Giá: ");
                        double price = scanner.nextDouble();

                        System.out.print("Số lượng: ");
                        int quantity = scanner.nextInt();

                        System.out.print("Nhà sản xuất: ");
                        String producer = scanner.next();

                        System.out.print("Xuất xứ (Không được là Việt Nam): ");
                        String country = scanner.next();
                        if (country.equals("Viet Nam")) throw new IllegalArgumentException("Xuất xứ Không được là Việt Nam");

                        System.out.println("1. Đã sửa chữa | 2. Chưa sửa chữa");
                        System.out.print("Trạng thái (1 hoặc 2): ");
                        int option = scanner.nextInt();
                        String condition;
                        if (option == 1) condition = "Da sua chua";
                        else if (option == 2) condition = "Chua sua chua";
                        else throw new IllegalArgumentException("Lựa chọn không hợp lệ");

                        PhoneManager.addPhone(new ImportedPhone(PhoneManager.createId(),name, price, quantity, producer, country, condition));
                        FileHandler.saveData();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Thông tin nhập sai, vui lòng nhập lại");
                        continue;
                    }
                    break;
                case 2:
                    try {
                        System.out.println("=== Thêm điện thoại chính hãng ===");

                        System.out.print("Tên: ");
                        String name = scanner.next();

                        System.out.print("Giá: ");
                        double price = scanner.nextDouble();

                        System.out.print("Số lượng: ");
                        int quantity = scanner.nextInt();

                        System.out.print("Nhà sản xuất: ");
                        String producer = scanner.next();

                        System.out.print("Hạn bảo hành (Không quá 730 ngày): ");
                        int warrantyDuration = scanner.nextInt();
                        if (warrantyDuration > 730) throw new IllegalArgumentException("Hạn bảo hành Không quá 730 ngày");

                        System.out.println("1. Quốc tế | 2. Toàn quốc");
                        System.out.print("Phạm vi bảo hành (1 hoặc 2): ");
                        int option = scanner.nextInt();
                        String warrantyCoverage;
                        if (option == 1) warrantyCoverage = "Quoc te";
                        else if (option == 2) warrantyCoverage = "Toan quoc";
                        else throw new IllegalArgumentException("Lựa chọn không hợp lệ");

                        PhoneManager.addPhone(new OfficalPhone(PhoneManager.createId(),name, price, quantity, producer, warrantyDuration, warrantyCoverage));
                        FileHandler.saveData();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Thông tin nhập sai, vui lòng nhập lại");
                        continue;
                    }
                    break;
                default:
                    System.out.println("##### Lựa chọn không hợp lệ #####");
                    break;
            }
            System.out.println("Thêm điện thoại thành công");
        }
    }

    public void deletePhone() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("    --- Xóa điện thoại ---");
            System.out.println("Nhập id điện thoại muốn xóa");
            System.out.print("Chọn: ");
            int id = scanner.nextInt();

            Phone target = PhoneManager.findPhoneById(id);
            if (target == null) System.out.println("Không tìm thấy điện thoại");
        }
    }

    public void displayPhoneList() {
        System.out.println("    --- Danh sách điện thoại ---");
        for (Phone phone : PhoneManager.getPhones()) {
            System.out.println(phone);
        }
    }
}
