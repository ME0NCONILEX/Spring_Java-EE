package mySpringTestMaster.DAO.Impl;
import org.springframework.stereotype.Component;
import mySpringTestMaster.DAO.AccountDao;
import mySpringTestMaster.DAO.Sequencer.AccountIdGenerator;
import mySpringTestMaster.Model.Account;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Component
public class AccountDaoImpl implements AccountDao {
    private List<Account> storage= new ArrayList<>();
    @Override
    public Account create(Account account) {
        // step1: validate the method parameters
        // step2: generate account number and set it to account id
        // step3: add account to storage
        // step4: return the result
        if(account == null) throw new IllegalArgumentException("account was null");
        Long accountId = AccountIdGenerator.generateAccountNumber();
        account.setId(accountId);
        storage.add(account);
        return account;
    }
    @Override
    public Optional<Account> findById(Long id) {
        if(id == null) throw new IllegalArgumentException("account id was null");
        return storage.stream() // stream source
                .filter(account -> account.getId().equals(id)) // used intermediate operation to create a small stream
                .findFirst(); // terminal operation used to make a result
    }
    @Override
    public Collection<Account> findAll() {
        return new ArrayList<>(storage);
    }
    @Override
    public void remove(Long aLong) {
        // todo: implement it in the next lecture
    }
}