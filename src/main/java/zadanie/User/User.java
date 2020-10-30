package zadanie.User;

import zadanie.Address;
import zadanie.Contract.Domain.Contract;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashMap;
import java.util.Map;

public class User {

    private static int idCounter = 0;
    private final int id;
    @Size(min = 1)
    private String name;
    @Size(min = 1)
    private String surname;
    @Size(min = 1)
    private final String personalNumber;
    @Size(min = 1)
    @Email
    private String mail;
    @NotNull
    private Address residentalAddress;
    private Address postalAddress;
    private Map<Integer, Contract> contracts;



    public String getFullName(){
        return name + " " + surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setResidentalAddress(Address residentalAddress) {
        this.residentalAddress = residentalAddress;
    }

    public void setPostalAddress(Address postalAddress) {
        this.postalAddress = postalAddress;
    }

    public void setContracts(Map<Integer, Contract> contracts) {
        this.contracts = contracts;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getMail() {
        return mail;
    }

    public Address getResidentalAddress() {
        return residentalAddress;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public Map<Integer, Contract> getContracts() {
        return contracts;
    }





    @Override
    public String toString() {
        return "User{" +
                "ID=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", residendalAddress=" + residentalAddress +
                ", postalAddress=" + postalAddress +
                ", contracts=\n" + contracts +
                '}';
    }

    public void addContract(Contract contract){
        this.contracts.put(contract.getId(), contract);
    }


    public User(String name, String surname, String personalNumber, String mail, Address residentalAddress, Address postalAddress) {
        idCounter +=1;
        this.id = idCounter;
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
        this.mail = mail;
        this.residentalAddress = residentalAddress;
        this.postalAddress = postalAddress;
        this.contracts = new HashMap<>();
    }

    public User(String name, String surname, String personalNumber, String mail, Address residentalAddress) {
        idCounter +=1;
        this.id = idCounter;
        this.name = name;
        this.surname = surname;
        this.personalNumber = personalNumber;
        this.mail = mail;
        this.residentalAddress = residentalAddress;
        this.postalAddress = residentalAddress;
        this.contracts = new HashMap<>();
    }
}
