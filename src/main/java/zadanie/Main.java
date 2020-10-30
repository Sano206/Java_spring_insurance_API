package zadanie;

import zadanie.Contract.Domain.Contract;
import zadanie.Contract.Domain.LifeInsurance.HealthInsurance;
import zadanie.Contract.Domain.LifeInsurance.TravelInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseAndApartmentInsurance;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;
import zadanie.Contract.ContractServices.ContractService;
import zadanie.User.User;
import zadanie.User.UserService;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {
        UserService userService = new UserService();
        ContractService contractService = new ContractService(userService);

        LocalDate date = LocalDate.now();

        Address jozovDom = new Address("95194", "Zapadakov", "prvomajovka", "666");
        Address ferovDom = new Address("34578", "hostieeee", "neni sa", "43g3");

        User jozo = new User( "jozo", "mrkvicka", "198384/684", "asldifn@slin.com", jozovDom);
        User fero = new User( "sdf", "sdfgjh", "asdg", "asdf.com", ferovDom);

        userService.addNewUser(jozo);                           //Pridanie noveho uzivatela
        userService.addNewUser(fero);

        Contract skuska = new HealthInsurance(date, date, date, 156, 156, jozo, fero, 156, 12,10, Validity.SLOVAKIA);
       // TravelInsurance skuska2 = new TravelInsurance(date, date, date, 156, 156, jozo, fero, true, Purpose.RELAX);
        Contract vymena = new HealthInsurance(date, date, date, 0, 0, jozo, fero, 0, 0,0, Validity.WORLD_AND_SLOVAKIA);
       // HouseAndApartmentInsurance dom = new HouseAndApartmentInsurance(date, date, date, 123, 234, fero, Type.FAMILY_HOUSE_BRICK, ferovDom, 12345, true);

      //  contractService.createContract(fero, dom);                     //Zalozenie zmluvy pouzivatelovi
        contractService.createContract(jozo, skuska);
        contractService.createContract(jozo, vymena);



        //Contract contract = contractService.findContractByID(1);
        HealthInsurance first = (HealthInsurance) contractService.findContractByID(1);
      //  first.editContract(first, vymena);
        contractService.updateHealthInsurance(first,(HealthInsurance) vymena);
        System.out.println(skuska.toString());

    }
}
