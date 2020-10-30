package zadanie.Contract.Domain.Resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import zadanie.Address;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TravelInsuranceResource {
    protected int id;   //contract
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
    @NotNull    //travell
    protected boolean eu;
    @NotNull
    protected Purpose purpose;
    @NotNull    //life
    protected int insured;

}
