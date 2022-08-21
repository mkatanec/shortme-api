package net.beardy.finance.shortme.controller;

import lombok.RequiredArgsConstructor;
import net.beardy.finance.shortme.controller.response.PageInfo;
import net.beardy.finance.shortme.controller.response.TransactionDetailsResponse;
import net.beardy.finance.shortme.controller.response.TransactionResponse;
import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.mapper.CreateMapper;
import net.beardy.finance.shortme.mapper.GenericCreateMapper;
import net.beardy.finance.shortme.mapper.Pair;
import net.beardy.finance.shortme.service.SuggestionService;
import net.beardy.finance.shortme.service.TransactionService;
import net.beardy.finance.shortme.service.dto.suggestion.AutomatedSuggestions;
import net.beardy.finance.shortme.service.dto.transaction.CreateTransactionCommand;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.service.dto.transaction.UpdateTransactionCommand;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final SuggestionService suggestionService;

    private final TransactionService transactionService;

    private final CreateMapper<Pair<Transaction, AutomatedSuggestions>, TransactionDetailsResponse>
        transactionDetailsResponseCreateMapper;

    private final GenericCreateMapper genericCreateMapper;

    @GetMapping
    public PageInfo<TransactionResponse> findAll(FindTransactionByQuery query) {
        final Page<Transaction> transactionPage = transactionService.findAll(query);
        final List<TransactionResponse> transactionResponses =
            genericCreateMapper.mapToList(transactionPage.getContent(), TransactionResponse.class);
        return new PageInfo<>(transactionResponses, transactionPage.getTotalElements(),
            (long) transactionPage.getNumber());
    }

    @GetMapping("/{id}")
    public TransactionDetailsResponse findById(@PathVariable Long id) {
        final Transaction transaction = transactionService.findById(id);
        final AutomatedSuggestions automatedSuggestions = suggestionService.getSuggestions(transaction);

        return transactionDetailsResponseCreateMapper.map(new Pair<>(transaction, automatedSuggestions));
    }

    @PostMapping
    public TransactionResponse create(@Validated @RequestBody CreateTransactionCommand createTransactionCommand) {
        return genericCreateMapper.map(transactionService.create(createTransactionCommand), TransactionResponse.class);
    }

    @PutMapping("/{id}")
    public TransactionResponse update(@Validated @RequestBody UpdateTransactionCommand updateTransactionCommand) {
        return genericCreateMapper.map(transactionService.update(updateTransactionCommand), TransactionResponse.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.delete(id);
    }

}
