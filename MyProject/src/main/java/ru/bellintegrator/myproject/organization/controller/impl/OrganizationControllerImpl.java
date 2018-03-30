package ru.bellintegrator.myproject.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.organization.model.Organization;
import ru.bellintegrator.myproject.organization.service.impl.OrganizationServiceImpl;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.organization.controller.OrganizationController;

import java.util.List;
import java.util.logging.Logger;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationServiceImpl organizationService;
    protected static Logger logger = Logger.getLogger(OrganizationControllerImpl.class.getName());

    @Autowired
    public OrganizationControllerImpl(OrganizationServiceImpl organizationService) {
        this.organizationService = organizationService;
    }

    //не работает
    @Override
    @ApiOperation(value = "allOrganization", nickname = "allOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = {POST})
    public List<OrganizationView> list(@RequestBody OrganizationView view) {
        logger.info("Geted all" );
        return organizationService.list();

    }
    //почти работает(сскорее всего ругается на id из-за автозаполнения, добавить OUT
    @Override
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public Organization getOrganizationById(@PathVariable Long id){
        logger.info("Organization get ID:" + id);
        return organizationService.getOrganizationById(id);

    }
    //работает, добавить OUT
    @Override
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/update", method = {POST})
    public void update(@RequestBody OrganizationView view){
        logger.info("Organization update " + view.toString());
        organizationService.update(view);
    }
    //работает, добавить OUT
    @Override
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/save", method = {POST})
    public void save(@RequestBody OrganizationView view){
         logger.info("Organization save" + view.toString());
         organizationService.save(view);

    }
    //работает, добавить OUT
    @Override
    @ApiOperation(value = "deleteOrganization", nickname = "deleteOrganization", httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {DELETE})
    public void delete (@PathVariable Long id){
        organizationService.delete(id);
        logger.info("Organization deleted ID:" + id);
    }
}
