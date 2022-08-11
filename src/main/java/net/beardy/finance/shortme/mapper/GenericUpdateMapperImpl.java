package net.beardy.finance.shortme.mapper;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenericUpdateMapperImpl implements GenericUpdateMapper {

    private final ModelMapper modelMapper;

    @Override
    public <T, U> void map(T from, U destination) {
        modelMapper.map(from, destination);
    }

}
