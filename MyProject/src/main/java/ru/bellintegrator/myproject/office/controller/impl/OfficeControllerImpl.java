package ru.bellintegrator.myproject.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.office.controller.OfficeController;
import ru.bellintegrator.myproject.office.model.Office;
import ru.bellintegrator.myproject.office.service.OfficeService;
import ru.bellintegrator.myproject.office.service.impl.OfficeServiceImpl;
import ru.bellintegrator.myproject.office.view.OfficeView;
import ru.bellintegrator.myproject.organization.controller.impl.OrganizationControllerImpl;

import java.util.List;
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
    @RequestMapping(method = {GET})
    public List<OfficeView> list(@RequestBody OfficeView view) {
        return officeService.list();
    }

    @Override
    @ApiOperation(value = "getOffice", nickname = "getOffice", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public Office getOfficeById(@PathVariable Long id) {
        logger.info("Office get ID:" + id);
        return officeService.getOfficeById(id);
    }

    @Override
    @ApiOperation(value = "updateOffice", nickname = "updateOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/update", method = {POST})
    public void update(@RequestBody OfficeView view) {
        logger.info("Office update " + view.toString());
        officeService.update(view);
    }

    @Override
    @ApiOperation(value = "saveOffice", nickname = "saveOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/save", method = {POST})
    public void save(@RequestBody OfficeView view) {
        logger.info("Office save " + view.toString());
        officeService.save(view);
    }

    @Override
    @ApiOperation(value = "deleteOffice", nickname = "deleteOffice", httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {DELETE})
    public void delete(@PathVariable Long id) {
        logger.info("Office deleted ID:" + id);
         officeService.delete(id);
    }
}
