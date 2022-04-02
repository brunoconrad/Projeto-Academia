package br.com.academia.exception;

public class IdNaoValidoServiceException extends RuntimeException{

    public IdNaoValidoServiceException(String message) {
        super(message);
    }
}
