package net.beardy.finance.shortme.repository;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import net.beardy.finance.shortme.specification.TransactionSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long>, JpaSpecificationExecutor<Transaction> {

    default Page<Transaction> findByQuery(FindTransactionByQuery query) {
        return findAll(TransactionSpecification.findByQuery(query),
            PageRequest.of(query.getPageIndex(), query.getPageSize()));
    }

}
