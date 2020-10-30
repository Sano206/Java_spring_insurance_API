package zadanie.Contract.Domain.LifeInsurance;

import zadanie.Contract.Enums.ContractType;
import zadanie.User.User;
import zadanie.Contract.Enums.Purpose;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TravelInsurance extends LifeInsurance {
    @NotNull
    protected boolean eu;
    @NotNull
    protected Purpose purpose;


    public boolean isEu() {
        return eu;
    }

    public void setEu(boolean eu) {
        this.eu = eu;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    @Override
    public String toString() {
        return "TravellInsurance{" +
                "eu=" + eu +
                ", purpose=" + purpose +
                ", insured=" + insured.getFullName() +
                ", id=" + id +
                ", issued=" + issued +
                ", start=" + start +
                ", end=" + end +
                ", amountInsured=" + amountInsured +
                ", paymentPm=" + paymentPm +
                ", insurer=" + insurer.getFullName() +
                "}\n";
    }

    public TravelInsurance(LocalDate issued, LocalDate start, LocalDate end, int amountInsured, int paymentPm, User insurer, User insured, boolean eu, Purpose purpose) {
        super(issued, start, end, amountInsured, paymentPm, insurer, insured);
        this.eu = eu;
        this.purpose = purpose;
    }

    public ContractType getContractType(){
        return ContractType.TRAVEL;
    }
}
