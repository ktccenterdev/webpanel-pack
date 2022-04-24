package net.webpanel.pack.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public  RecordNotFoundException(String message){
        super(message);
    }
}
