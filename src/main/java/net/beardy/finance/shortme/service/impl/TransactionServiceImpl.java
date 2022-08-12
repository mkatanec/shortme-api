package net.beardy.finance.shortme.service.impl;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.exception.EntityNotFoundException;
import net.beardy.finance.shortme.mapper.CreateMapper;
import net.beardy.finance.shortme.mapper.UpdateMapper;
import net.beardy.finance.shortme.repository.TransactionRepository;
import net.beardy.finance.shortme.service.TransactionService;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    private final CreateMapper<CreateTransactionCommand, Transaction> transactionCreateMapper;

    private final UpdateMapper<UpdateTransactionCommand, Transaction> transactionUpdateMapper;

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(Transaction.class, String.format("id=%d", id)));
    }

    @Override
    public Page<Transaction> findAll(FindTransactionByQuery query) {
        return transactionRepository.findByQuery(query);
    }

    @Override
    public Transaction create(CreateTransactionCommand createTransactionCommand) {
        return transactionRepository.save(transactionCreateMapper.map(createTransactionCommand));
    }

    @Override
    public Transaction update(UpdateTransactionCommand updateTransactionCommand) {
        final Transaction transaction = findById(updateTransactionCommand.getId());

        transactionUpdateMapper.map(updateTransactionCommand, transaction);

        return transactionRepository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        transactionRepository.delete(findById(id));
    }

}
