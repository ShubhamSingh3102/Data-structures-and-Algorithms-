package Exception_Handling;
public class MyException extends Exception{
    MyException(String msg){
        super(msg);
    }
}

class Papu{
    static void fail(int marks) throws MyException{
        if(marks<30){
            throw new MyException("Papu fail ho gya!!");
        }
    }
}