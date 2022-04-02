package Data;

import org.testng.annotations.DataProvider;

public class DataUsers {

    @DataProvider( name = "users")
    public  static Object[][] getUsers(){
        return new Object[][]
                {
                        {"Matias Anriquez", "Argentina", "Buenos Aires", "404585747878547", "12", "26"}
                };
    }
}
