package zadanie.Contract.Domain.Resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import zadanie.Address;
import zadanie.Contract.Domain.LifeInsurance.HealthInsurance;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;
import zadanie.User.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HealthInsuranceResource {
    protected int id;
    @NotNull
    @PastOrPresent
    protected LocalDate issued;
    @PastOrPresent
    @NotNull
    protected LocalDate start;
    @PastOrPresent
    @NotNull
    protected LocalDate end;
    @Min(0)
    protected int amountInsured;
    @Min(0)
    protected int paymentPm;
    @NotNull
    protected int insurer;
    @NotNull
    protected int insured;
    @Min(0)
    protected int longTermInjury;
    @Min(0)
    protected int deathDueInjury;
    @Min(0)
    protected int compensationPerDay;
    @NotNull
    protected Validity validity;

    public HealthInsuranceResource(HealthInsurance contract) {
        this.id = contract.getId();
        this.issued = contract.getIssued();
        this.start = contract.getStart();
        this.end = contract.getEnd();
        this.amountInsured = contract.getAmountInsured();
        this.paymentPm = contract.getPaymentPm();
        this.insurer = contract.getInsurer().getId();
        this.insured = contract.getInsured().getId();
        this.longTermInjury = contract.getLongTermInjury();
        this.deathDueInjury = contract.getDeathDueInjury();
        this.compensationPerDay = contract.getCompensationPerDay();
        this.validity = contract.getValidity();
    }

    public HealthInsurance toItem(){
        return new HealthInsurance(issued,start,end,amountInsured,paymentPm,null,null,longTermInjury,deathDueInjury,compensationPerDay,validity);
    }
}
