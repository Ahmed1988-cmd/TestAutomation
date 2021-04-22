package tests;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.IOException;
import pages.nagwaHomePage;

public class nagwaLessonTest extends TestBase

{
    nagwaHomePage nagwaHomeOBJ;

     private static String SearchText;


    private static String filePath = "C:\\Users\\ZaZa\\IdeaProjects\\Automation\\src\\test\\java\\data\\testData.json";

    /**
     * this function for reading test data from json file
     * @throws IOException
     * @throws ParseException
     */
    public void getDataForTesting() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(filePath);

        //Read JSON file
        Object dataObj = jsonParser.parse(reader);
        JSONObject resultObj = (JSONObject) dataObj;

        SearchText = (String) resultObj.get("SearchText");

    }

    @Test (priority = 1,alwaysRun = true)
    public void FirstUserCanRegister() throws IOException, ParseException, InterruptedException {
      getDataForTesting();

        nagwaHomeOBJ = new nagwaHomePage(driver);
        nagwaHomeOBJ.nagwaLesson(SearchText);
      //  Assert.assertTrue(creaAcounttObj.SucceseMessage.getText().contains("YOUR PERSONAL INFORMATION"));
       // System.out.println(creaAcounttObj+"TEST PAAAAAASSSSS");

    }


}

