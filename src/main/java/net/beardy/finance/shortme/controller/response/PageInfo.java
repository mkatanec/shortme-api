package net.beardy.finance.shortme.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class PageInfo<T> {

    private Collection<T> result;

    private Long totalItemCount;

    private Long currentPage;

}
