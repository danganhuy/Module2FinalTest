package dienThoai;

public class ImportedPhone extends Phone {
    private String country;
    private String condition;

    public ImportedPhone(int id, String name, double price,
                         int quantity, String producer,
                         String country, String condition) {
        super(id, name, price, quantity, producer);
        this.country = country;
        this.condition = condition;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "ImportedPhone{" +
                "country='" + country + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
