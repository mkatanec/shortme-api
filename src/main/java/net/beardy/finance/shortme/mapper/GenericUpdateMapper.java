package net.beardy.finance.shortme.mapper;

public interface GenericUpdateMapper {

    <T, U> void map(T from, U destination);

}
