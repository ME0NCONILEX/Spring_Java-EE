package mySpringTestMaster.DAO;
import mySpringTestMaster.Model.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer, Long>{
    abstract List<Customer> findByName(String firstName);
}
