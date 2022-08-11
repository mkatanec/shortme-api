package net.beardy.finance.shortme.controller;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.controller.response.TransactionResponse;
import net.beardy.finance.shortme.mapper.GenericCreateMapper;
import net.beardy.finance.shortme.service.TransactionService;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    private final GenericCreateMapper genericCreateMapper;

    @GetMapping
    public List<TransactionResponse> findAll(FindTransactionByQuery query) {
        return genericCreateMapper.mapToList(transactionService.findAll(query), TransactionResponse.class);
    }

    @GetMapping("/{id}")
    public TransactionResponse fondById(@PathVariable Long id) {
        return genericCreateMapper.map(transactionService.findById(id), TransactionResponse.class);
    }

    @PostMapping
    public TransactionResponse create(CreateTransactionCommand createTransactionCommand) {
        return genericCreateMapper.map(transactionService.create(createTransactionCommand), TransactionResponse.class);
    }

    @PutMapping("/{id}")
    public TransactionResponse update(UpdateTransactionCommand updateTransactionCommand) {
        return genericCreateMapper.map(transactionService.update(updateTransactionCommand), TransactionResponse.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }

}
