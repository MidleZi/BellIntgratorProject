package ru.bellintegrator.myproject.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.utils.ControllerException;
import ru.bellintegrator.myproject.organization.service.impl.OrganizationServiceImpl;
import ru.bellintegrator.myproject.organization.view.OrganizationFilterView;
import ru.bellintegrator.myproject.organization.view.OrganizationView;
import ru.bellintegrator.myproject.organization.controller.OrganizationController;
import ru.bellintegrator.myproject.utils.Response;
import ru.bellintegrator.myproject.utils.ResponseViewData;
import ru.bellintegrator.myproject.utils.ResponseViewError;
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

    @Override
    @ApiOperation(value = "getAllOrganization", nickname = "getAllOrganization", httpMethod = "GET")
    @RequestMapping(value = "/all", method = {GET})
    public Response getAllOrganization() {
        try {
            Object data = organizationService.getAllOrganization();
            logger.info("All Office: ");

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
    @ApiOperation(value = "listOrganization", nickname = "listOrganization", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public Response list(@RequestBody OrganizationFilterView view) {
        try {
            if(view.name == null) throw new ControllerException();
            Object data = organizationService.list(view);

            logger.info("Geted List" + data );

            return ResponseViewData.newBuilder()
                    .setData(data)
                    .build();


        } catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }


    }

    @Override
    @ApiOperation(value = "getOrganization", nickname = "getOrganization", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public Response getOrganizationById(@PathVariable Long id){
        logger.info("Organization get ID:" + id);

        try {
            if(id == null) throw new ControllerException();
            Object data = organizationService.getOrganizationById(id);
            logger.info("Organization deleted ID:" + id);

            return ResponseViewData.newBuilder()
                    .setData(data)
                    .build();


        } catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }

    }

    @Override
    @ApiOperation(value = "updateOrganization", nickname = "updateOrganization", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public Response update(@RequestBody OrganizationView view){

        try {
            if(view.id == null) throw new ControllerException();
            organizationService.update(view);;
            logger.info("Organization update " + view.toString());

            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();


        } catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }

    @Override
    @ApiOperation(value = "saveOrganization", nickname = "saveOrganization", httpMethod = "POST")
    @RequestMapping(value = "/save", method = {POST})
    public Response save(@RequestBody OrganizationView view) {

        try {
            organizationService.save(view);
            logger.info("Organization save" + view.toString());

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
    @ApiOperation(value = "deleteOrganization", nickname = "deleteOrganization", httpMethod = "DELETE")
    @RequestMapping(value = "/{id}", method = {DELETE})
    public Response delete (@PathVariable Long id){
        try {
            if(id == null) throw new ControllerException();
            organizationService.delete(id);
            logger.info("Organization deleted ID:" + id);

            return ResponseViewData.newBuilder()
                    .setData("success")
                    .build();


        } catch (Throwable e) {
            return ResponseViewError.newBuilder()
                    .setError(e.getMessage())
                    .build();
        }
    }
}
