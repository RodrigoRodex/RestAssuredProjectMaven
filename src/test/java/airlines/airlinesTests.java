package airlines;


import Utils.JsonUtils;
import io.restassured.response.Response;
import org.restUtils.restUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class airlinesTests {
    @Test
    public void createAirline() throws IOException {

        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        Map<String,String> data = JsonUtils.getJsonDataAsMap("airlines/dev/qa/dev/"+env+"/airlinesApiData.json");
        String endPoint = data.get("createAirLineEndpoint");
        Map<String, Object> payLoad = payloads.getCreateAirlinePayLoadFromMap("12456789", "Quatar Airlines",
                "Quatar", "https:upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svq/300px-Qatar_Airways_Logo.svq.png",
                "Going Places Together", "Qatar Airways Towers, Doha, Qatar",
                "www.qatarairways.com", "1994");
        Response response = restUtils.performPost(endPoint,payLoad, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
