package phone;

public class OfficalPhone extends Phone {
    private int warrantyDuration;
    private String warrantyCoverage;

    public OfficalPhone(int id, String name, double price,
                        int quantity, String producer,
                        int warrantyDuration, String warrantyCoverage) {
        super(id, name, price, quantity, producer);
        setWarrantyDuration(warrantyDuration);
        setWarrantyCoverage(warrantyCoverage);
    }

    public int getWarrantyDuration() throws IllegalArgumentException {
        if (warrantyDuration < 0) {
            throw new IllegalArgumentException("Warranty duration cannot be negative");
        }
        if (warrantyDuration > 730) {
            throw new IllegalArgumentException("Warranty duration cannot be greater than 730 days (2 years)");
        }
        return warrantyDuration;
    }

    public void setWarrantyDuration(int warrantyDuration) {
        this.warrantyDuration = warrantyDuration;
    }

    public String getWarrantyCoverage() {
        return warrantyCoverage;
    }

    public void setWarrantyCoverage(String warrantyCoverage) {
        if (!warrantyCoverage.equals("Quoc te") && !warrantyCoverage.equals("Toan quoc")) {
            throw new IllegalArgumentException("Warranty coverage have to be \"Quoc te\" or \"Toan quoc\"");
        }
        this.warrantyCoverage = warrantyCoverage;
    }

    @Override
    public String toString() {
        return super.getId() +"," + super.getName() +"," + super.getPrice() +
                "," + super.getQuantity() +"," + super.getProducer() +
                "," + warrantyDuration +"," + warrantyCoverage;
    }
}
