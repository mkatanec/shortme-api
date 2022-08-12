package net.beardy.finance.shortme.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface CreateMapper<T, U> {

    U map(T from);

    default List<U> mapToList(Collection<T> list) {
        return list.stream().map(this::map).collect(Collectors.toList());
    }

}
