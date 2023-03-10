package mySpringTestMaster.DAO.Impl;
import org.springframework.stereotype.Component;
import mySpringTestMaster.DAO.CustomerDao;
import mySpringTestMaster.DAO.Sequencer.CustomerIdSequencer;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Model.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Component
public class CustomerDaoImpl implements CustomerDao {
    private List<Customer> storage = new ArrayList<>();
    @Override
    public Customer create(Customer customer) {
        if (customer == null) throw new IllegalArgumentException("customer was null");
        Long customerId = CustomerIdSequencer.nextId();
        customer.setId(customerId);
        storage.add(customer);
        return customer;
    }
    @Override
    public Optional<Customer> findById(Long id) {
        if (id == null) throw new IllegalArgumentException("customer id was null");
        return storage.stream() // stream source
                .filter(customer -> customer.getId().equals(id)) // used intermediate operation to create a small stream
                .findFirst(); // terminal operation used to make a result
    }
    @Override
    public Collection<Customer> findAll() {
        return new ArrayList<>(storage);
    }
    @Override
    public void remove(Long customerId) throws DataNotFoundException {
        Optional<Customer> optionalCustomer = findById(customerId);
        if (!optionalCustomer.isPresent()) throw new DataNotFoundException("data not found exception");
        else storage.remove(optionalCustomer.get());
    }
    @Override
    public List<Customer> findByName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("firstName was null");
    /*List<Customer> filteredList = new ArrayList<>();
    for(Customer element : storage){
      if(element.getFirstName().equals(firstName)){
        filteredList.add(element);
      }
    }
    return filteredList;*/
        return storage.stream()
                .filter(element -> element.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }
}