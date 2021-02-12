package com.enorkus.academy.validator;

public abstract class Validator<T> {

    public abstract void validate(T attribute, String message);
}
