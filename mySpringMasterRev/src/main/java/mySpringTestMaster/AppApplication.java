package mySpringTestMaster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import mySpringTestMaster.Config.AppConfig;
import mySpringTestMaster.DAO.AccountDao;
import mySpringTestMaster.DAO.CustomerDao;
import mySpringTestMaster.Model.Account;
import mySpringTestMaster.Model.Customer;
import mySpringTestMaster.Service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class AppApplication {
    public static void main(String[] args) {
        //AccountDao accountDao = new AccountDaoImpl();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CustomerService customerService = context.getBean(CustomerService.class);
        System.out.println(customerService.registerCustomer(new Customer("My","Name",new Account(123))));
        System.out.println(customerService.registerCustomer(new Customer("Me","0nly",new Account(124))));
    }
}nt8