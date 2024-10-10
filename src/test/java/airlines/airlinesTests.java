package airlines;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utils.RestUtils;

import java.util.HashMap;

public class airlinesTests {
    @Test
    public void createAirline(){
        String endPoint = "https://api.instantwebtools.net/v1/airlines";
        String payLoad = "{\n" +
                "        \"id\":12456778,\n" +
                "        \"name\": \"Quatar Airways\",\n" +
                "        \"country\": \"Quatar\",\n" +
                "        \"logo\": \"https:upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svq/300px-Qatar_Airways_Logo.svq.png\",\n" +
                "        \"slogan\": \"Going Places Together\",\n" +
                "        \"head_quaters\": \"Qatar Airways Towers, Doha, Qatar\",\n" +
                "        \"website\": \"www.qatarairways.com\", \n" +
                "        \"established\": \"1994\"\n"+
                "}";
        Response response = RestUtils.performPost(endPoint,payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
