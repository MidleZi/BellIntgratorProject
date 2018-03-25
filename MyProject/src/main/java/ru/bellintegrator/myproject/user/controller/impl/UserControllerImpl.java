package ru.bellintegrator.myproject.user.controller.impl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.office.view.OfficeFilterView;
import ru.bellintegrator.myproject.user.controller.UserController;
import ru.bellintegrator.myproject.user.service.UserService;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserResponseView;
import ru.bellintegrator.myproject.user.view.UserView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService usersService) {
        this.userService = usersService;
    }


    @ApiOperation(value = "allUser", nickname = "allUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(method = {GET})
    public List<UserView> all(@RequestBody UserFilterView view) {
        return userService.all();
    }

    @Override
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {GET})
    public UserResponseView getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Override
    @ApiOperation(value = "updateUser", nickname = "updateUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/update", method = {POST})
    public UserResponseView update(@RequestBody UserView view) {
        return userService.update(view);
    }

    @Override
    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/save", method = {POST})
    public UserResponseView save(@RequestBody UserView view) {
        return userService.save(view);
    }

    @Override
    @ApiOperation(value = "deleteUser", nickname = "deleteUser", httpMethod = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @RequestMapping(value = "/{id}", method = {DELETE})
    public UserResponseView delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}

