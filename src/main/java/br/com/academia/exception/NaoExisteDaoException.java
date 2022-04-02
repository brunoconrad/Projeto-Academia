package br.com.academia.exception;

public class NaoExisteDaoException extends RuntimeException{

    public NaoExisteDaoException(String message) {
        super(message);
    }

}
