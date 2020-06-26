public class ExceptionTest {
    static void callDriver() throws ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println("finish");
    }
    public static void main(String args[]){
        try {
            callDriver();
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            System.out.println("end of program");
        }
    }
}
