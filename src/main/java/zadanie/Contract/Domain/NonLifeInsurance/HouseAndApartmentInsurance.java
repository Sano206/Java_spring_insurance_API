package zadanie.Contract.Domain.NonLifeInsurance;

import zadanie.Address;
import zadanie.Contract.Enums.ContractType;
import zadanie.User.User;

import zadanie.Contract.Enums.Type;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class HouseAndApartmentInsurance extends PropertyInsurance {
    @NotNull
    protected boolean garageInsurance;

    public boolean isGarageInsurance() {
        return garageInsurance;
    }

    public void setGarageInsurance(boolean garageInsurance) {
        this.garageInsurance = garageInsurance;
    }

    @Override
    public String toString() {
        return "HouseAndAppartmentInsurance{" +
                "garageInsurance=" + garageInsurance +
                ", type=" + type +
                ", address=" + address +
                ", value=" + value +
                ", id=" + id +
                ", issued=" + issued +
                ", start=" + start +
                ", end=" + end +
                ", amountInsured=" + amountInsured +
                ", paymentPm=" + paymentPm +
                ", insurer=" + insurer.getFullName() +
                "}\n";
    }

    public HouseAndApartmentInsurance(LocalDate issued,
                                      LocalDate start,
                                      LocalDate end,
                                      int amountInsured,
                                      int paymentPm,
                                      User insurer,
                                      Type type,
                                      Address address,
                                      int value,
                                      boolean garageInsurance) {
        super(issued, start, end, amountInsured, paymentPm, insurer, type, address, value);
        this.garageInsurance = garageInsurance;
    }

    public ContractType getContractType(){
        return ContractType.HOUSE;
    }

}
