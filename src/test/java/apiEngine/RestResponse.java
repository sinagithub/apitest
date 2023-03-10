package apiEngine;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
@SuppressWarnings("unchecked")
public class RestResponse<X> implements IRestResponse<X> {
    private X data;
    private Response response;
    private Exception e;

    public RestResponse(Class<X> x, Response response) {
        this.response = response;
        try {
            this.data = x.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Should be a default constructor in the Response POJO");
        }
    }

    public String getContent() {
        return response.getBody().asString();
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public boolean isSuccessful() {
        int code = response.getStatusCode();
        if (code == 200 || code == 201 || code == 202 || code == 203 || code == 204 || code == 205) return true;
        return false;
    }

    public String getStatusDescription() {
        return response.getStatusLine();
    }

    public Response getResponse() {
        return response;
    }


    public X getBody() {
        try {
            data = (X) response.getBody().as(data.getClass());
        } catch (Exception e) {
            this.e = e;
        }
        return data;
    }

    public void schemaValidator(String format, String path) {
        if(format.equals("JSON")){
            response.then().assertThat().contentType(ContentType.JSON)
                    .and()
                    .body(matchesJsonSchemaInClasspath(path));

        }
    }


    public Exception getException() {
        return e;
    }

}
