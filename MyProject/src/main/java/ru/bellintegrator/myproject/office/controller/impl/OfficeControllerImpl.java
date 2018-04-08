package ru.bellintegrator.myproject.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.exceptions.OfficeControllerException;
import ru.bellintegrator.myproject.exceptions.OrganizationControllerException;
import ru.bellintegrator.myproject.office.controller.OfficeController;
import ru.bellintegrator.myproject.office.service.impl.OfficeServiceImpl;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.utils.Response;
import ru.bellintegrator.myproject.utils.ResponseViewData;
import ru.bellintegrator.myproject.utils.ResponseViewError;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeServiceImpl officeService;
    protected static Logger logger = Logger.getLogger(OfficeControllerImpl.class.getName());

    @Autowired
    public OfficeControllerImpl(OfficeServiceImpl officeService) {
        this.officeService = officeService;
    }


    @Override
    @ApiOperation(value = "allOffice", nickname = "allOffice", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public Response list(@RequestBody OfficeFilterView view) {
        try {
            if(view.name == null) throw new OrganizationControllerException();
            Object data = officeService.list(view);

            logger.info("Geted List" + data );

            return ResponseViewData.newBuilder()
                    .setData(data)
                    .build();


        }
        catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public Response getOfficeById(@PathVariable Long id) {

        try {
            if(id == null) throw new OfficeControllerException();
            Object data = officeService.getOfficeById(id);

            logger.info("Office get ID:" + id);

            return ResponseViewData.newBuilder()
                    .setData(data)
                    .build();


        }
        catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public Response update(@RequestBody OfficeView view) {
        logger.info("Office update " + view.toString());
        officeService.update(view);

        try {
            if(view.id == null) throw new OfficeControllerException();
            officeService.save(view);

            logger.info("Office save " + view.toString());

            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }
        catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @RequestMapping(value = "/save", method = {POST})
    public Response save(@RequestBody OfficeView view) {

        try {
            officeService.save(view);

            logger.info("Office save " + view.toString());

            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }
        catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @ApiOperation(value = "deleteOffice", nickname = "deleteOffice", httpMethod = "DELETE")
    @RequestMapping(value = "/{id}", method = {DELETE})
    public Response delete(@PathVariable Long id) {

        try {
            if(id == null) throw new OfficeControllerException();
            officeService.delete(id);

            logger.info("Office deleted ID:" + id);

            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();
        }
        catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
}
