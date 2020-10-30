package zadanie.Contract.Domain.Resources;

import lombok.Data;
import lombok.NoArgsConstructor;
import zadanie.Address;
import zadanie.Contract.Domain.NonLifeInsurance.HouseholdInsurance;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class HouseholdInsuranceResource {
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

    @NotNull    //property
    protected Type type;

    //@NotNull
   // protected Address address;


    @Size(min = 1)
    private String postalNumber;
    @Size(min = 1)
    private String city;
    @Size(min = 1)
    private String street;
    @Size(min = 1)
    private String orientationalNumber;

    @Min(0)
    protected int value;

    @Min(0)     //household
    protected int equipmentWorth;


}
