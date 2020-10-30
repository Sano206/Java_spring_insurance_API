package zadanie.Contract.Domain.NonLifeInsurance;

import zadanie.Address;
import zadanie.User.User;
import zadanie.Contract.Domain.Contract;
import zadanie.Contract.Enums.Type;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public abstract class PropertyInsurance extends Contract {
    @NotNull
    protected Type type;
    @NotNull
    protected Address address;
    @Min(0)
    protected int value;

    public PropertyInsurance(LocalDate issued, LocalDate start, LocalDate end, int amountInsured, int paymentPm, User insurer, Type type, Address address, int value) {
        super(issued, start, end, amountInsured, paymentPm, insurer);
        this.type = type;
        this.address = address;
        this.value = value;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
