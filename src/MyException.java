public class MyException extends  Exception {

    public MyException() {
        super("my exception");
    }
}
class ExceptionTest2{
    static void callException() throws MyException{
        throw new MyException();
    }

    public static void main(String[] args){
        try {
            callException();
        }catch (MyException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("end of System");
        }
    }
}
