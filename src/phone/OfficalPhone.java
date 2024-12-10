package phone;

public class OfficalPhone extends Phone {
    private int warrantyDuration;
    private String warrantyCoverage;

    public OfficalPhone(int id, String name, double price,
                        int quantity, String producer,
                        int warrantyDuration, String warrantyCoverage) {
        super(id, name, price, quantity, producer);
        this.warrantyDuration = warrantyDuration;
        this.warrantyCoverage = warrantyCoverage;
    }

    public int getWarrantyDuration() {
        return warrantyDuration;
    }

    public void setWarrantyDuration(int warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    public String toString() {
        return "DienThoaiChinhHang{" +
                "warrantyDuration=" + warrantyDuration +
                ", warrantyCoverage='" + warrantyCoverage + '\'' +
                '}';
    }
}
