package neiseApi.exception;

public class TooBigRegioinException extends RuntimeException{
    public TooBigRegioinException(){
        super("너무 큰 범위입니다.");
    }
}
