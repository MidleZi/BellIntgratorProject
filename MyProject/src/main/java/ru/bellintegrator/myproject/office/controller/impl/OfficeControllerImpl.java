package ru.bellintegrator.myproject.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bellintegrator.myproject.office.controller.OfficeController;
import ru.bellintegrator.myproject.office.service.OfficeService;
import ru.bellintegrator.myproject.office.view.OfficeView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeService) {
        this.officeService = officeService;
    }


    @Override
    @ApiOperation(value = "addOffice", nickname = "addOffice", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/office", method = {POST})
    public void office(@RequestBody OfficeView office) {
        officeService.add(office);
    }

    @Override
    @ApiOperation(value = "getOffices", nickname = "getOffices", httpMethod = "GET")
    @RequestMapping(value = "/office", method = {GET})
    public List<OfficeView> offices() {
        return officeService.offices();
    }
}