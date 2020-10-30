package zadanie.Contract.Domain.LifeInsurance;

import zadanie.User.User;
import zadanie.Contract.Domain.Contract;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public abstract class LifeInsurance extends Contract {
    @NotNull
    protected final User insured;

    public LifeInsurance(LocalDate issued, LocalDate start, LocalDate end, int amountInsured, int paymentPm, User insurer, User insured) {
        super(issued, start, end, amountInsured, paymentPm, insurer);
        this.insured = insured;
    }


    public User getInsured() {
        return insured;
    }


}
