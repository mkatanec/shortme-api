package net.beardy.finance.shortme.mapper;

public interface UpdateMapper<T, U> {

    void map(T from, U to);

}
