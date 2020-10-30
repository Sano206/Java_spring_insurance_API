package zadanie.Contract.Domain.NonLifeInsurance;

import zadanie.Address;
import zadanie.Contract.Enums.ContractType;
import zadanie.User.User;

import zadanie.Contract.Enums.Type;

import javax.validation.constraints.Min;
import java.time.LocalDate;

public class HouseholdInsurance extends PropertyInsurance {
    @Min(0)
    protected int equipmentWorth;

    public int getEquipmentWorth() {
        return equipmentWorth;
    }

    public void setEquipmentWorth(int equipmentWorth) {
        this.equipmentWorth = equipmentWorth;
    }

    public HouseholdInsurance(LocalDate issued, LocalDate start, LocalDate end, int amountInsured, int paymentPm, User insurer, Type type, Address address, int value, int equipmentWorth) {
        super(issued, start, end, amountInsured, paymentPm, insurer, type, address, value);
        this.equipmentWorth = equipmentWorth;
    }

    @Override
    public String toString() {
        return "HouseholdInsurance{" +
                "equipmentWorth=" + equipmentWorth +
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

    public ContractType getContractType(){
        return ContractType.HOUSEHOLD;
    }

}
