package pl.asseco.workshop.calculationModule.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.asseco.workshop.calculationModule.Services.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.xml.ws.Response;
import java.util.ArrayList;

/**
 * Created by krzysztof.bogucki on 28 lip 2017.
 */
@EnableSwagger2
@RestController
@Api(value = "sum", description = "Serwisy obługujące obliczenia dla modułu ")
public class AdderController {


    @Autowired
    private AdderService adderService;

    @Autowired
    private AdderProvider adderProvider;

    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Success", response = Sum.class),
            @ApiResponse(code = 401, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 403, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 404, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorInfo.class)
    })
    @RequestMapping(value = "/getSum", method = RequestMethod.GET)
    public Sum getSum() {
        Sum result = new Sum();
        result.setAdderSum(adderService.sum());
        result.setAdderItems(adderProvider.getItems());
        return result;
    }


    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Success", response = SuccessInfo.class),
            @ApiResponse(code = 401, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 403, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 404, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorInfo.class)
    })
    @RequestMapping(value = "/setItems", method = RequestMethod.POST)
    public SuccessInfo setItem(@RequestParam(value="items", defaultValue="") String items) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        String[] data = items.split(",");
        for (int i = 0; i < data.length; i++){
            list.add( Integer.parseInt(data[i]));
        }
        adderProvider.setListItems(list);

        SuccessInfo msg = new SuccessInfo();
        msg.setMessage("Twoje dane zostały poprawnie dodane do tablicy przeliczeniowej w ilości " + list.size() + " elementów");
        return msg;
    }


    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Success", response = SuccessInfo.class),
            @ApiResponse(code = 401, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 403, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 404, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorInfo.class)
    })
    @RequestMapping(value = "/updateItem", method = RequestMethod.PUT)
    public SuccessInfo updateItems(@RequestBody UpdateItem updateItem ) {

        ArrayList<Integer> items = adderProvider.getItems();
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == updateItem.getTarget()){
               items.remove(i);
               items.add(updateItem.getValue());
            }
        }

        adderProvider.setListItems(items);

        SuccessInfo msg = new SuccessInfo();
        msg.setMessage("Twoje dane zostały poprawnie zaktualizowane w tablicy przeliczeniowej " + updateItem.getTarget());
        return msg;
    }


    @ApiResponses(value={
            @ApiResponse(code = 201, message = "Success", response = SuccessInfo.class),
            @ApiResponse(code = 401, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 403, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 404, message = "Success", response = ErrorInfo.class),
            @ApiResponse(code = 500, message = "Server error", response = ErrorInfo.class)
    })
    @RequestMapping(value = "/removeItem", method = RequestMethod.DELETE)
    public SuccessInfo removeItems(@RequestHeader Integer item) {

        ArrayList<Integer> items = adderProvider.getItems();
        Boolean isHasTarget = false;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == item){
                items.remove(i);
                isHasTarget = true;
            }
        }

        adderProvider.setListItems(items);

        SuccessInfo msg = new SuccessInfo();
        if(isHasTarget){
            msg.setMessage("Identyfikator został poprawnie usunięty");
        } else {
            msg.setMessage("Brak identyfikatora w tablicy");
        }

        return msg;
    }


}
