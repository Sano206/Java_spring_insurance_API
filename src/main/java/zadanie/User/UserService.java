package zadanie.User;

import org.springframework.stereotype.Service;
import zadanie.Contract.Domain.Contract;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer, User> users;

    public UserService() {
        users = new HashMap<>();
    }

    public void addNewUser(User user){
        if (user == null){
            throw new IllegalArgumentException();
        }
        users.put(user.getId(), user);
    }

    public User findUserById(int id) {
        return users.values().stream()
                .filter(user -> user.getId() == id)
                .findFirst().orElse(null);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }


    public void editUser(User first, User second){
        if (first == null || second == null){
            throw new IllegalArgumentException("Invalid arguments");
        }
        first.setName(second.getName());
        first.setSurname(second.getSurname());
        first.setMail(second.getMail());
        //first.setPostalAddress(second.getPostalAddress());
        //first.setResidendalAddress(second.getResidendalAddress());
        first.getResidentalAddress().updateAddress(first.getResidentalAddress(), second.getResidentalAddress());
        first.getResidentalAddress().updateAddress(first.getPostalAddress(), second.getPostalAddress());

    }

    public void addContractToUser(int id, Contract contract){
        User user = findUserById(id);
        user.addContract(contract);
    }




}
