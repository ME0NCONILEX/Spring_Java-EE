package mySpringTestMaster.Service;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Model.Customer;
public interface CustomerService {
    Customer registerCustomer(Customer customerData);

    abstract Customer findById(Long id) throws DataNotFoundException;
}
