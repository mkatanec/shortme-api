package net.beardy.finance.shortme.specification;

import net.beardy.finance.shortme.entity.Transaction;
import net.beardy.finance.shortme.entity.TransactionType;
import net.beardy.finance.shortme.entity.Transaction_;
import net.beardy.finance.shortme.entity.registry.TradingPair_;
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

            if (Objects.nonNull(query.getTradingPairs())) {
                predicates.add(getTradingPair(query.getTradingPairs(), transaction));
            }

            if (predicates.isEmpty()) {
                return cb.and();
            }

            return cb.or(predicates.toArray(new Predicate[0]));
        };
    }

    public static Predicate getTransactionType(List<TransactionType> transactionTypes, Root<Transaction> transaction) {
        final Expression<String> transactionTypePath = transaction.get(Transaction_.TRANSACTION_TYPE);

        return transactionTypePath.in(transactionTypes);
    }

    public static Predicate getTradingPair(List<Long> tradingPairIds, Root<Transaction> transaction) {
        final Expression<Long> transactionTypePath = transaction.get(Transaction_.TRADING_PAIR).get(TradingPair_.ID);

        return transactionTypePath.in(tradingPairIds);
    }

}
