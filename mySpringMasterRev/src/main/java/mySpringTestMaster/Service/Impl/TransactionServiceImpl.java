package mySpringTestMaster.Service.Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mySpringTestMaster.DAO.AccountDao;
import mySpringTestMaster.DAO.CustomerDao;
import mySpringTestMaster.DAO.TransactionDao;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Exception.InsufficientFoundsException;
import mySpringTestMaster.Model.Account;
import mySpringTestMaster.Model.Customer;
import mySpringTestMaster.Model.Transaction;
import mySpringTestMaster.Model.TransactionType;
import mySpringTestMaster.Service.TransactionService;
@Component
public class TransactionServiceImpl implements TransactionService {
    CustomerDao customerDao;
    AccountDao accountDao;
    TransactionDao transactionDao;
    @Autowired
    public TransactionServiceImpl(CustomerDao customerDao, AccountDao accountDao, TransactionDao transactionDao) {
        this.customerDao = customerDao;
        this.accountDao = accountDao;
        this.transactionDao = transactionDao;
    }
    @Override
    public Transaction moneyTransfer(Long customerId, double amount, TransactionType type) throws DataNotFoundException, InsufficientFoundsException {
        if (customerId == null) throw new IllegalArgumentException("customer id was null");
        Customer customer = customerDao.findById(customerId)
                .orElseThrow(()-> new DataNotFoundException("customer id was not valid"));
        Account account = customer.getAccount();
        if (type.equals(TransactionType.DEPOSIT))account.deposit(amount);
        else account.withdraw(amount);
        accountDao.updateBalance(account);
        Transaction transactionData = new Transaction(customer, type, amount);
        Transaction createdTransaction = transactionDao.create(transactionData);
        return createdTransaction;
    }
    //todo: add more logics
}