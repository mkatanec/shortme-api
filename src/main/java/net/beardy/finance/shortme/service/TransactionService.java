package net.beardy.finance.shortme.service;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;
import org.springframework.data.domain.Page;

public interface TransactionService {

    Transaction findById(Long id);

    Page<Transaction> findAll(FindTransactionByQuery query);

    Transaction create(CreateTransactionCommand createTransactionCommand);

    Transaction update(UpdateTransactionCommand updateTransactionCommand);

    void delete(Long id);

}
