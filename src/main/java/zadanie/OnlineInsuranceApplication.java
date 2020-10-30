package zadanie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zadanie.Contract.Domain.LifeInsurance.HealthInsurance;
import zadanie.Contract.Domain.LifeInsurance.TravelInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseAndApartmentInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseholdInsurance;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;
import zadanie.Contract.ContractServices.ContractService;
import zadanie.User.User;
import zadanie.User.UserService;

import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class OnlineInsuranceApplication implements CommandLineRunner {
    private final UserService userService;
    private final ContractService contractService;

    public OnlineInsuranceApplication(UserService userService, ContractService contractService ) {
        this.userService = userService;
        this.contractService = contractService;
    }


    public static void main(String[] args) {
        SpringApplication.run(OnlineInsuranceApplication.class, args);
        log.info("Open in browser: http://localhost:8080");
    }

    @Override
    public void run(String... args) throws Exception {



        LocalDate date = LocalDate.now();

        Address jozovDom = new Address("95194", "Hostie", "prvomajovka", "666");
        Address ferovDom = new Address("34578", "Moravce", "hocijaka", "adf4385");
        Address danovDom = new Address("123456", "Nitra", "Mostna", "a1635");
        Address petrovDom = new Address("3985745578", "Bratislava", "Obchodna", "1588b/n");

        User jozo = new User( "jozo", "mrkvicka", "198384/684", "asldifn@slin.com", jozovDom);
        User fero = new User( "fero", "dodok", "153fgd53", "aaaaaaaaaaa@sdf.com", ferovDom);
        User dano = new User( "Dano", "Komar", "123456789", "bbbbbbbbb@sdf.com", danovDom);
        User peter = new User( "Peter", "Ondris", "4867532", "asdf@sdf.com", petrovDom);

        userService.addNewUser(jozo);                           //Pridanie noveho uzivatela
        userService.addNewUser(fero);
        userService.addNewUser(dano);
        userService.addNewUser(peter);


        HealthInsurance skuska = new HealthInsurance(date, date, date, 156, 156, jozo, fero, 156, 12,10, Validity.SLOVAKIA);
        TravelInsurance skuska2 = new TravelInsurance(date, date, date, 666, 666, jozo, fero, true, Purpose.RELAX);
        HealthInsurance vymena = new HealthInsurance(date, date, date, 0, 0, dano, peter, 0, 0,0, Validity.WORLD_AND_SLOVAKIA);
        HouseAndApartmentInsurance dom = new HouseAndApartmentInsurance(date, date, date, 123, 234, fero, Type.FAMILY_HOUSE_BRICK, ferovDom, 12345, true);
        HouseholdInsurance dalsidom = new HouseholdInsurance(date, date, date, 9999,9999,dano, Type.FLAT, petrovDom,44444,8888);

        contractService.createContract(peter, dalsidom);
        contractService.createContract(fero, dom);                     //Zalozenie zmluvy pouzivatelovi
        contractService.createContract(jozo, skuska);
        contractService.createContract(jozo, skuska2);
    }

}
