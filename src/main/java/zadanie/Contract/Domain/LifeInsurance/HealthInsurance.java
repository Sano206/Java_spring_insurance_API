package zadanie.Contract.Domain.LifeInsurance;


import zadanie.Contract.Enums.ContractType;
import zadanie.User.User;
import zadanie.Contract.Enums.Validity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class HealthInsurance extends LifeInsurance {
    @Min(0)
    protected int longTermInjury;
    @Min(0)
    protected int deathDueInjury;
    @Min(0)
    protected int compensationPerDay;
    @NotNull
    protected Validity validity;




    public int getLongTermInjury() {
        return longTermInjury;
    }

    public void setLongTermInjury(int longTermInjury) {
        this.longTermInjury = longTermInjury;
    }

    public int getDeathDueInjury() {
        return deathDueInjury;
    }

    public void setDeathDueInjury(int deathDueInjury) {
        this.deathDueInjury = deathDueInjury;
    }

    public int getCompensationPerDay() {
        return compensationPerDay;
    }

    public void setCompensationPerDay(int compensationPerDay) {
        this.compensationPerDay = compensationPerDay;
    }

    public Validity getValidity() {
        return validity;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "HealthInsurance{" +
                "longTermInjury=" + longTermInjury +
                ", deathDueInjury=" + deathDueInjury +
                ", compensationPerDay=" + compensationPerDay +
                ", validity=" + validity +
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

    public HealthInsurance(LocalDate issued,
                           LocalDate start,
                           LocalDate end,
                           int amountInsured,
                           int paymentPm,
                           User insurer,
                           User insured,
                           int longTermInjury,
                           int deathDueInjury,
                           int compensationPerDay,
                           Validity validity) {
        super(issued, start, end, amountInsured, paymentPm, insurer, insured);
        this.longTermInjury = longTermInjury;
        this.deathDueInjury = deathDueInjury;
        this.compensationPerDay = compensationPerDay;
        this.validity = validity;
    }

    public ContractType getContractType(){
        return ContractType.HEALTH;
    }


}
