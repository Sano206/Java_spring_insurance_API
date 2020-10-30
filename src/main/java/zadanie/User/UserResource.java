package zadanie.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import zadanie.Address;
import zadanie.Contract.Domain.Contract;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Map;

@NoArgsConstructor
@Data
public class UserResource {
    @Size(min = 1)
    private String name;
    @Size(min = 1)
    private String surname;
    @Size(min = 1)
    private String personalNumber;
    @Size(min = 1)
    @Email
    private String mail;
    @Size(min = 1)
    private String postalNumber;
    @Size(min = 1)
    private String city;
    @Size(min = 1)
    private String street;
    @Size(min = 1)
    private String orientationalNumber;
    private Map<Integer, Contract> contracts;

    public UserResource(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.personalNumber = user.getPersonalNumber();
        this.mail = user.getMail();
        this.contracts = user.getContracts();
        this.postalNumber = user.getResidentalAddress().getPostalNumber();
        this.city = user.getResidentalAddress().getCity();
        this.street = user.getResidentalAddress().getStreet();
        this.orientationalNumber = user.getResidentalAddress().getOrientationalNumber();
    }

    public User toUser(){
        Address address = new Address(postalNumber, city, street, orientationalNumber);
        return new User(name,surname,personalNumber,mail, address, address);
    }

}
