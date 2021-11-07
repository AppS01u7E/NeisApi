package neiseApi.exception;

public class InvaildDateException extends RuntimeException{
    public InvaildDateException(){
        super("유효하지 않은 날짜 입력입니다.");
    }
}
