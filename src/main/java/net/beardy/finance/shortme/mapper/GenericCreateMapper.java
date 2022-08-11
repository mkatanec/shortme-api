package net.beardy.finance.shortme.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericCreateMapper {

    <T, U> U map(T from, Class<U> toClass);

    default <T, U> List<U> mapToList(Collection<T> list, Class<U> toClass) {
        return list.stream().map(item -> map(item, toClass)).collect(Collectors.toList());
    }

}
