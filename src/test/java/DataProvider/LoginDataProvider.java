package DataProvider;

import org.testng.annotations.DataProvider;
import utils.DataReader;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {
        Object[] loginData = DataReader.getLoginData("jsonfiles/loginData.json");
        return new Object[][]{
                {loginData[0], loginData[1]}
        };
    }
}

