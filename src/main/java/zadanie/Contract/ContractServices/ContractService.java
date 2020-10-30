package zadanie.Contract.ContractServices;

import org.springframework.stereotype.Service;
import zadanie.Contract.Domain.LifeInsurance.HealthInsurance;
import zadanie.Contract.Domain.LifeInsurance.TravelInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseAndApartmentInsurance;
import zadanie.Contract.Domain.NonLifeInsurance.HouseholdInsurance;
import zadanie.Contract.Enums.ContractType;
import zadanie.User.User;
import zadanie.User.UserService;
import zadanie.Contract.Domain.Contract;

import java.util.HashMap;
import java.util.Map;

@Service
public class ContractService {

    private final UserService userService;
    private Map<Integer, Contract> contracts;

    public ContractService(UserService userService) {
        this.userService = userService;
        contracts = new HashMap<>();
    }

    public void createContract(User user, Contract contract){
        user.addContract(contract);
        contracts.put(contract.getId(), contract);
    }

    public void updateHealthInsurance(HealthInsurance first, HealthInsurance second){ //TODO
        first.editContract(first,second);
        first.setCompensationPerDay(second.getCompensationPerDay());
        first.setDeathDueInjury(second.getDeathDueInjury());
        first.setLongTermInjury(second.getLongTermInjury());
        first.setValidity(second.getValidity());
    }

    public void updateTravelInsurance(TravelInsurance first, TravelInsurance second) { //TODO
        first.editContract(first, second);
        first.setStart(second.getStart());
        first.setEu(second.isEu());
        first.setPurpose(second.getPurpose());
    }

    public void updateHouseholdInsurance(HouseholdInsurance first, HouseholdInsurance second){
        first.editContract(first, second);
        first.getAddress().updateAddress(first.getAddress(), second.getAddress());
        first.setType(second.getType());
        first.setValue(second.getValue());
        first.setEquipmentWorth(second.getEquipmentWorth());
    }

    public void updateHouseAndApartmentInsurance(HouseAndApartmentInsurance first, HouseAndApartmentInsurance second){
        first.editContract(first, second);
        first.getAddress().updateAddress(first.getAddress(), second.getAddress());
        first.setType(second.getType());
        first.setValue(second.getValue());
        first.setGarageInsurance(second.isGarageInsurance());
    }



    public Map<Integer, Contract> findContractsByUserId(int id){
        User user = userService.findUserById(id);
        return user.getContracts();
    }

    public Contract findContractByID(int id){
        return contracts.values().stream().
                filter(contract -> contract.getId() == id).findFirst().orElse(null);
    }

    public Map<Integer, Contract> getContracts() {
        return contracts;
    }

    public ContractType getContractType(Object contract){
        if (contract instanceof HealthInsurance)
            return ContractType.HEALTH;
        if (contract instanceof TravelInsurance)
            return ContractType.TRAVEL;
        if (contract instanceof HouseholdInsurance)
            return ContractType.HOUSEHOLD;
        if (contract instanceof HouseAndApartmentInsurance)
            return  ContractType.HOUSE;
        return null;
    }
}
