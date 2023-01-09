package mySpringTestMaster.DAO;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Model.Account;
public interface AccountDao extends BaseDao<Account, Long>{
    void updateBalance(Account account) throws DataNotFoundException;
}