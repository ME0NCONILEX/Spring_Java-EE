package mySpringTestMaster.Config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import mySpringTestMaster.DAO.Impl.AccountDaoImpl;
import mySpringTestMaster.DAO.AccountDao;
@Configuration
@ComponentScan(basePackages = "mySpringTestMaster")
public class AppConfig {
  /* @Bean
  public Scanner scanner(){
    return new Scanner(System.in);
  } */
}