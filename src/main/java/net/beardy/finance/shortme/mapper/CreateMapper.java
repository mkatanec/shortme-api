package net.beardy.finance.shortme.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface CreateMapper<T, U> {

    U map(T from);

    default List<U> mapToList(Collection<T> list, Class<U> toClass) {
        return list.stream().map(item -> map(item)).collect(Collectors.toList());
    }

}
