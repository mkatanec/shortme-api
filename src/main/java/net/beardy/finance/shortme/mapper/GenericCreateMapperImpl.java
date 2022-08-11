package net.beardy.finance.shortme.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GenericCreateMapperImpl implements GenericCreateMapper {

    private final ModelMapper modelMapper;

    @Override
    public <T, U> U map(T from, Class<U> toClass) {
        return modelMapper.map(from, toClass);
    }

}
