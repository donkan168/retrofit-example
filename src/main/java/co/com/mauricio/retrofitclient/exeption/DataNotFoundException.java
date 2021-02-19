package co.com.mauricio.retrofitclient.exeption;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
    }

    public DataNotFoundException(String message)
    {
        super(message);
    }

}  