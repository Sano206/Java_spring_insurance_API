package zadanie.Contract.Domain;

import zadanie.User.User;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;


public abstract class Contract {
    private static int idCounter = 0;
    protected final int id;
    @PastOrPresent
    @NotNull
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
    protected final User insurer;


    public void editContract(Contract first, Contract second){
        first.setPaymentPm(second.getPaymentPm());
        first.setAmountInsured(second.getAmountInsured());
        first.setEnd(second.getEnd());
        first.setIssued(second.getIssued());
        first.setStart(second.getStart());
    };

    public Contract(LocalDate issued, LocalDate start, LocalDate end, int amountInsured, int paymentPm, User insurer) {
        idCounter +=1;
        this.id = idCounter;
        this.issued = issued;
        this.start = start;
        this.end = end;
        this.amountInsured = amountInsured;
        this.paymentPm = paymentPm;
        this.insurer = insurer;
    }


    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Contract.idCounter = idCounter;
    }

    public int getId() {
        return id;
    }

    public LocalDate getIssued() {
        return issued;
    }

    public void setIssued(LocalDate issued) {
        this.issued = issued;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getAmountInsured() {
        return amountInsured;
    }

    public void setAmountInsured(int amountInsured) {
        this.amountInsured = amountInsured;
    }

    public int getPaymentPm() {
        return paymentPm;
    }

    public void setPaymentPm(int paymentPm) {
        this.paymentPm = paymentPm;
    }

    public User getInsurer() {
        return insurer;
    }


}

