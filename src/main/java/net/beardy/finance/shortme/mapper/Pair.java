package net.beardy.finance.shortme.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pair<T, U> {

    private T first;

    private U second;

}
