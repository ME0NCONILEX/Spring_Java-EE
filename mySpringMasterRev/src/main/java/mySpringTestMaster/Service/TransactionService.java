package mySpringTestMaster.Service;
import mySpringTestMaster.Exception.DataNotFoundException;
import mySpringTestMaster.Exception.InsufficientFoundsException;
import mySpringTestMaster.Model.Transaction;
import mySpringTestMaster.Model.TransactionType;
public interface TransactionService {
    abstract Transaction moneyTransfer(Long customerId, double amount, TransactionType type) throws DataNotFoundException, InsufficientFoundsException;
}
