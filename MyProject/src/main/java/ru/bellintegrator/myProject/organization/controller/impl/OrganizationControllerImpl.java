package ru.bellintegrator.myProject.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bellintegrator.myProject.organization.service.OrganizationService;
import ru.bellintegrator.myProject.organization.view.OrganizationView;
import ru.bellintegrator.myProject.organization.controller.OrganizationController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }


    @Override
    @ApiOperation(value = "addOrganization", nickname = "addOrganization", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/organization", method = {POST})
    public void organization(@RequestBody OrganizationView organization) {
        organizationService.add(organization);
    }

    @Override
    @ApiOperation(value = "getOrganizations", nickname = "getOrganizations", httpMethod = "GET")
    @RequestMapping(value = "/organization", method = {GET})
    public List<OrganizationView> organizations() {
        return organizationService.organizations();
    }
}
