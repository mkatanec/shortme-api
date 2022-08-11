package net.beardy.finance.shortme.exception;

import java.util.Arrays;

public class EntityNotFoundException extends RuntimeException {

    private static final String ENTITY_NOT_FOUND_MESSAGE = "%s could not be found using following search criteria: %s!";

    public EntityNotFoundException(Class<?> clazz, String... searchParams) {
        super(String.format(ENTITY_NOT_FOUND_MESSAGE, clazz.getSimpleName(), Arrays.toString(searchParams)));
    }

}
