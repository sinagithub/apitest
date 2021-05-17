package clients.carsi;

import apiEngine.IRestResponse;
import apiEngine.RestResponse;
import apiEngine.Routes.OrderRoute;
import apiEngine.Routes.Route;
import apiEngine.models.requests.Order.WriteOrderNoteRequest;
import apiEngine.models.response.Order.ActiveOrdersResponse;
import apiEngine.models.response.Order.GetOrderNotesResponse;
import apiEngine.models.response.Order.WriteOrderNoteResponse;
import com.sun.tools.corba.se.idl.constExpr.Or;
import io.restassured.response.Response;


public class CarsiOrderClient extends CarsiClient {
    public CarsiOrderClient(String baseUrl) {
        super(baseUrl);
    }

    public IRestResponse<ActiveOrdersResponse> getActiveOrders() {
        Response response = createRequest()
                .get(Route.getActiveOrders());
        writeStepLog();
        return new RestResponse<>(ActiveOrdersResponse.class, response);
    }

    public IRestResponse<GetOrderNotesResponse>getOrderNotes(){
        Response response = createRequest()
                .get(OrderRoute.getNote());
        writeStepLog();
        return new RestResponse<>(GetOrderNotesResponse.class, response);
    }

    public IRestResponse<WriteOrderNoteResponse>writeOrderNote(String writeOrderNote){
        WriteOrderNoteRequest writeOrderNoteRequest = new WriteOrderNoteRequest(writeOrderNote);
        Response response = createRequest()
                .body(writeOrderNoteRequest)
                .post(OrderRoute.getNote());
        writeStepLog();
        return new RestResponse<>(WriteOrderNoteResponse.class, response);

    }
}
