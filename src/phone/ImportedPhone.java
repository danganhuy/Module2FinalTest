package phone;

public class ImportedPhone extends Phone {
    private String country;
    private String condition;

    public ImportedPhone(int id, String name, double price,
                         int quantity, String producer,
                         String country, String condition) {
        super(id, name, price, quantity, producer);
        setCountry(country);
        setCondition(condition);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) throws IllegalArgumentException {
        if (country.equals("Viet Nam"))
            throw new IllegalArgumentException("Can't be Viet Nam");
        this.country = country;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if (!condition.equals("Da sua chua") && !condition.equals("Chua sua chua")) {
            throw new IllegalArgumentException
                    ("Condition have to be \"Da sua chua\" or \"Chua sua chua\"");
        }
        this.condition = condition;
    }

    @Override
    public String toString() {
        return super.getId() + "," + super.getName() + "," + super.getPrice() +
                "," + super.getQuantity() + "," + super.getProducer() +
                "," + country + "," + condition;
    }
}
