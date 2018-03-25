package ru.bellintegrator.myproject.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.organization.service.OrganizationService;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.organization.controller.OrganizationController;
import ru.bellintegrator.myproject.organization.view.OrganizationResponseView;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;
    protected static Logger logger = Logger.getLogger("controller");

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @Override
    @ApiOperation(value = "allOrganization", nickname = "allOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = {GET})
    public List<OrganizationView> all(@RequestBody OrganizationView view) {
        return organizationService.all();
    }

    @Override
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {GET})
    public OrganizationResponseView getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationById(id);
    }

    @Override
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/update", method = {POST})
    public OrganizationResponseView update(@RequestBody OrganizationView view){
        return organizationService.update(view);
    }

    @Override
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/save", method = {POST})
    public OrganizationResponseView save(@RequestBody OrganizationView view){
        return organizationService.save(view);
    }

    @Override
    @ApiOperation(value = "deleteOrganization", nickname = "deleteOrganization", httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {DELETE})
    public OrganizationResponseView delete (@PathVariable Long id){
        return organizationService.delete(id);
    }
}
