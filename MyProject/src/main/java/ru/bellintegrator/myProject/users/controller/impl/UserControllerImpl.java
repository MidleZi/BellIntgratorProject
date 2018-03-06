package ru.bellintegrator.myProject.users.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.bellintegrator.myProject.users.controller.UsersController;
import ru.bellintegrator.myProject.users.service.UsersService;
import ru.bellintegrator.myProject.users.view.UsersView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

public class UserControllerImpl implements UsersController {

    private final UsersService usersService;

    @Autowired
    public UserControllerImpl(UsersService usersService) {
        this.usersService = usersService;
    }


    @Override
    @ApiOperation(value = "addUsers", nickname = "addUsers", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/organization", method = {POST})
    public void users(@RequestBody UsersView users) {
        usersService.add(users);
    }

    @Override
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @RequestMapping(value = "/organization", method = {GET})
    public List<UsersView> user() {
        return usersService.user();
    }
}
