package mySpringTestMaster.Service;
import mySpringTestMaster.Config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mySpringTestMaster.DAO.AccountDao;
import mySpringTestMaster.DAO.CustomerDao;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Model.Account;
import mySpringTestMaster.Model.Customer;
import mySpringTestMaster.Service.CustomerService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

// @ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public final class CustomerServiceTest {
    @Autowired
    CustomerService testObject;
    Customer createdCustomer;
    @BeforeEach
    public void setup() {
        Account accountData = new Account(20.00);
        Customer customerData = new Customer("Test", "Test", accountData);
        createdCustomer = testObject.registerCustomer(customerData);
    }
//    @Test
    public void findById() {
        assertDoesNotThrow( () -> testObject.findById(createdCustomer.getId()));
    }
    //todo: add more unit tests
    //maybe...someday ;) Done!
}
