package net.beardy.finance.shortme.config;

import net.beardy.finance.shortme.controller.response.TransactionDetailsResponse;
import net.beardy.finance.shortme.controller.response.TransactionResponse;
import net.beardy.finance.shortme.entity.Transaction;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.typeMap(Transaction.class, TransactionResponse.class)
            .addMappings(mapper -> {
                mapper.map(transaction -> transaction.getTradeItem().getName(), TransactionResponse::setTradeItemName);
            });
        modelMapper.typeMap(Transaction.class, TransactionDetailsResponse.class)
            .addMappings(mapper -> {
                mapper.map(transaction -> transaction.getTradeItem().getName(),
                    TransactionDetailsResponse::setTradeItemName);
            });

        return modelMapper;
    }

}
