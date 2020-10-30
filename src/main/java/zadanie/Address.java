package zadanie;

import lombok.Data;
import zadanie.Contract.Domain.NonLifeInsurance.HouseAndApartmentInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseholdInsurance;
import zadanie.Contract.Domain.Resources.HouseAndApartmentInsuranceResource;
import zadanie.Contract.Domain.Resources.HouseholdInsuranceResource;

import javax.validation.constraints.Size;

@Data
public class Address {
    @Size(min = 1)
    private String postalNumber;
    @Size(min = 1)
    private String city;
    @Size(min = 1)
    private String street;
    @Size(min = 1)
    private String orientationalNumber;


    @Override
    public String toString() {
        return postalNumber +' ' + city + ","  + street + ", " +orientationalNumber;
    }

    public Address(HouseAndApartmentInsuranceResource resource) {
        this.postalNumber = resource.getPostalNumber();
        this.city = resource.getCity();
        this.street = resource.getStreet();
        this.orientationalNumber = resource.getOrientationalNumber();
    }


    public Address(HouseholdInsuranceResource resource) {
        this.postalNumber = resource.getPostalNumber();
        this.city = resource.getCity();
        this.street = resource.getStreet();
        this.orientationalNumber = resource.getOrientationalNumber();
    }

    public Address(String postalNumber, String city, String street, String number) {
        this.postalNumber = postalNumber;
        this.city = city;
        this.street = street;
        this.orientationalNumber = number;
    }

    public void updateAddress(Address first, Address second){
        first.setCity(second.getCity());
        first.setOrientationalNumber(second.getOrientationalNumber());
        first.setPostalNumber(second.getPostalNumber());
        first.setStreet(second.getStreet());
    }
}
