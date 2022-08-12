package net.beardy.finance.shortme.specification;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.entity.TransactionType;
import net.beardy.finance.shortme.service.dto.transaction.FindTransactionByQuery;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class TransactionSpecification {

    private TransactionSpecification() {
        throw new UnsupportedOperationException("Utility");
    }

    public static Specification<Transaction> findByQuery(FindTransactionByQuery query) {
        return (Root<Transaction> transaction, CriteriaQuery<?> cq, CriteriaBuilder cb) -> {
            final List<Predicate> predicates = new ArrayList<>();

            if (Objects.nonNull(query.getTransactionTypes())) {
                predicates.add(getTransactionType(query.getTransactionTypes(), transaction));
            }

            if (Objects.nonNull(query.getTradeItems())) {
                predicates.add(getTradeItem(query.getTradeItems(), transaction));
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Predicate getTransactionType(List<TransactionType> transactionTypes, Root<Transaction> transaction) {
        final Expression<String> transactionTypePath = transaction.get("transactionType");

        return transactionTypePath.in(transactionTypes);
    }

    public static Predicate getTradeItem(List<Long> tradeItemIds, Root<Transaction> transaction) {
        final Expression<Long> transactionTypePath = transaction.get("tradeItem").get("id");

        return transactionTypePath.in(tradeItemIds);
    }

}
