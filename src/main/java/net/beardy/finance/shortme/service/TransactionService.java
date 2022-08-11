package net.beardy.finance.shortme.service;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;

import java.util.List;

public interface TransactionService {

    Transaction findById(Long id);

    List<Transaction> findAll(FindTransactionByQuery query);

    Transaction create(CreateTransactionCommand createTransactionCommand);

    Transaction update(UpdateTransactionCommand updateTransactionCommand);

    void delete(Long id);

}
