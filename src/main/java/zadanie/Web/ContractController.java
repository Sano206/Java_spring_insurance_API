package zadanie.Web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import zadanie.Address;
import zadanie.Contract.Domain.Contract;
import zadanie.Contract.Domain.LifeInsurance.TravelInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseAndApartmentInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseholdInsurance;
import zadanie.Contract.Domain.Resources.HealthInsuranceResource;
import zadanie.Contract.Domain.LifeInsurance.HealthInsurance;
import zadanie.Contract.Domain.Resources.HouseAndApartmentInsuranceResource;
import zadanie.Contract.Domain.Resources.HouseholdInsuranceResource;
import zadanie.Contract.Domain.Resources.TravelInsuranceResource;
import zadanie.Contract.Enums.Purpose;
import zadanie.Contract.Enums.Type;
import zadanie.Contract.Enums.Validity;
import zadanie.Contract.ContractServices.ContractService;
import zadanie.User.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/contract")
public class ContractController {

    private final ContractService contractService;
    private final UserService userService;

    @Autowired
    public ContractController(ContractService contractService, UserService userService) {
        this.contractService = contractService;
        this.userService = userService;
    }


    @GetMapping("/detail/{id}")
    public String detailContract(@PathVariable int id, Model model){
        Contract contract = contractService.findContractByID(id);
        if(contract instanceof HealthInsurance){
            HealthInsurance resource =(HealthInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/detail/detailContractHealth";
        }
        else if(contract instanceof  TravelInsurance){
            TravelInsurance resource = (TravelInsurance) contract;
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("contract", resource);
            return "/contract/detail/detailContractTravel";
        }
        else if(contract instanceof HouseAndApartmentInsurance){
            HouseAndApartmentInsurance resource = (HouseAndApartmentInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/detail/detailContractHouseAndApartment";
        }
        else if(contract instanceof  HouseholdInsurance){
            HouseholdInsurance resource = (HouseholdInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/detail/detailContractHousehold";
        }
        return "/index";


    }

    @GetMapping("/healthInsurance")
    public String healthInsuranceForm(Model model){
        model.addAttribute("resource", new HealthInsuranceResource());
        model.addAttribute("validities", Validity.values());
        model.addAttribute("users", userService.getUsers().values());
        return "/contract/add/healthInsuranceAdd";
    }

    @PostMapping("/healthInsuranceAdd")
    public String healthInsurancePost(@ModelAttribute("resource") @Valid HealthInsuranceResource resource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("validities", Validity.values());
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/add/healthInsuranceAdd";
        }
        HealthInsurance contract = new HealthInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()), userService.findUserById(resource.getInsured()), resource.getLongTermInjury(), resource.getDeathDueInjury(), resource.getCompensationPerDay(), resource.getValidity());
        contractService.createContract(userService.findUserById(resource.getInsurer()), contract);
        return "/index";
    }

    @GetMapping("/travelInsurance")
    public String travelInsuranceForm(Model model){
        model.addAttribute("resource", new TravelInsuranceResource());
        model.addAttribute("purposes", Purpose.values());
        model.addAttribute("users", userService.getUsers().values());
        return "/contract/add/travelInsuranceAdd";
    }

    @PostMapping("/travelInsuranceAdd")
    public String travelInsurancePost(@ModelAttribute("resource") @Valid TravelInsuranceResource resource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("purposes", Purpose.values());
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/add/travelInsuranceAdd";
        }
        TravelInsurance contract = new TravelInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()), userService.findUserById(resource.getInsured()),resource.isEu(),resource.getPurpose());
        contractService.createContract(userService.findUserById(resource.getInsurer()), contract);
        return "/index";
    }

    @GetMapping("/householdInsurance")
    public String householdInsuranceForm(Model model){
        model.addAttribute("resource", new HouseholdInsuranceResource());
        model.addAttribute("types", Type.values());
        model.addAttribute("users", userService.getUsers().values());
        return "/contract/add/householdInsuranceAdd";
    }

    @PostMapping("/householdInsuranceAdd")
    public String householdInsurancePost(@ModelAttribute("resource") @Valid HouseholdInsuranceResource resource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("types", Type.values());
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/add/householdInsuranceAdd";
        }
        Address address = new Address(resource);
        HouseholdInsurance contract = new HouseholdInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()),resource.getType(), address, resource.getValue(),resource.getEquipmentWorth() );
        contractService.createContract(userService.findUserById(resource.getInsurer()), contract);
        return "/index";
    }

    @GetMapping("/houseAndApartmentInsurance")
    public String houseAndApartmentInsuranceForm(Model model){
        model.addAttribute("resource", new HouseAndApartmentInsuranceResource());
        model.addAttribute("types", Type.values());
        model.addAttribute("users", userService.getUsers().values());
        return "/contract/add/houseAndApartmentInsuranceAdd";
    }

    @PostMapping("/houseAndApartmentInsurance")
    public String houseAndApartmentInsurancePost(@ModelAttribute("resource") @Valid HouseAndApartmentInsuranceResource resource, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("types", Type.values());
            model.addAttribute("users", userService.getUsers().values());
            return "/contract/add/houseAndApartmentInsuranceAdd";
        }
        Address address = new Address(resource);
        HouseAndApartmentInsurance contract = new HouseAndApartmentInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()),resource.getType(), address, resource.getValue(),resource.isGarageInsurance() );
        contractService.createContract(userService.findUserById(resource.getInsurer()), contract);
        return "/index";
    }

/////////////////////////////////////////////
    ////EDIT////

    @GetMapping("/edit/{id}")
    public String healthInsuranceEditForm(@PathVariable int id, Model model){
        Contract contract = contractService.findContractByID(id);
        if(contract instanceof HealthInsurance){
            HealthInsurance resource =(HealthInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("validities", Validity.values());
            model.addAttribute("id", id);
            return "/contract/edit/healthInsuranceEdit";
        }
        else if(contract instanceof  TravelInsurance){
            TravelInsurance resource = (TravelInsurance) contract;
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("contract", resource);
            model.addAttribute("purposes",Purpose.values());
            model.addAttribute("id", id);
            return "/contract/edit/travelInsuranceEdit";
        }
        else if(contract instanceof HouseAndApartmentInsurance){
            HouseAndApartmentInsurance resource = (HouseAndApartmentInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("types", Type.values());
            model.addAttribute("id", id);
            return "/contract/edit/houseAndApartmentInsuranceEdit";
        }
        else if(contract instanceof  HouseholdInsurance){
            HouseholdInsurance resource = (HouseholdInsurance) contract;
            model.addAttribute("contract", resource);
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("types", Type.values());
            model.addAttribute("id", id);
            return "/contract/edit/householdInsuranceEdit";
        }
        return "/index";
    }

    @PostMapping("/edit/healthInsuranceEdit/{id}")
    public String healthInsuranceEditPost(@ModelAttribute("resource") @Valid HealthInsuranceResource resource,@PathVariable int id, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("validities", Validity.values());
            model.addAttribute("id", id);
            return "/contract/edit/healthInsuranceEdit";
        }
        HealthInsurance first = (HealthInsurance) contractService.findContractByID(id);
        HealthInsurance second = new HealthInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()),userService.findUserById(resource.getInsured()), resource.getLongTermInjury(), resource.getDeathDueInjury(), resource.getCompensationPerDay(), resource.getValidity());
        contractService.updateHealthInsurance(first,second);
        return "/index";
    }

    @PostMapping("/edit/travelInsuranceEdit/{id}")
    public String travelInsuranceEditPost(@ModelAttribute("resource") @Valid TravelInsuranceResource resource,@PathVariable int id, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("validities", Validity.values());
            model.addAttribute("id", id);
            return "/contract/edit/travelInsuranceEdit";
        }
        TravelInsurance first = (TravelInsurance) contractService.findContractByID(id);
        TravelInsurance second = new TravelInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()),userService.findUserById(resource.getInsured()), resource.isEu(), resource.getPurpose());
        contractService.updateTravelInsurance(first,second);
        return "/index";
    }

    @PostMapping("/edit/householdInsuranceEdit/{id}")
    public String householdInsuranceEditPost(@ModelAttribute("resource") @Valid HouseholdInsuranceResource resource,@PathVariable int id, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("validities", Type.values());
            model.addAttribute("id", id);
            return "/contract/edit/householdInsuranceEdit";
        }
        HouseholdInsurance first = (HouseholdInsurance) contractService.findContractByID(id);
        Address address = new Address(resource);
        HouseholdInsurance second = new HouseholdInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()), resource.getType(), address, resource.getValue(), resource.getEquipmentWorth());
        contractService.updateHouseholdInsurance(first,second);
        return "/index";
    }

    @PostMapping("/edit/houseAndApartmentInsuranceEdit/{id}")
    public String houseAndApartmentInsuranceEditPost(@ModelAttribute("resource") @Valid HouseAndApartmentInsuranceResource resource,@PathVariable int id, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("users", userService.getUsers().values());
            model.addAttribute("validities", Type.values());
            model.addAttribute("id", id);
            return "/contract/edit/houseAndApartmentInsuranceEdit";
        }
        HouseAndApartmentInsurance first = (HouseAndApartmentInsurance) contractService.findContractByID(id);
        Address address = new Address(resource);
        HouseAndApartmentInsurance second = new HouseAndApartmentInsurance(resource.getIssued(), resource.getStart(), resource.getEnd(), resource.getAmountInsured(), resource.getPaymentPm(), userService.findUserById(resource.getInsurer()), resource.getType(), address, resource.getValue(), resource.isGarageInsurance());
        contractService.updateHouseAndApartmentInsurance(first,second);
        return "/index";
    }

}
