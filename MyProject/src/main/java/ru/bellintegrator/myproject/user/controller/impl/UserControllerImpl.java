package ru.bellintegrator.myproject.user.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.myproject.utils.ControllerException;
import ru.bellintegrator.myproject.user.controller.UserController;
import ru.bellintegrator.myproject.user.service.UserService;
import ru.bellintegrator.myproject.user.view.UserFilterView;
import ru.bellintegrator.myproject.user.view.UserView;
import ru.bellintegrator.myproject.utils.Response;
import ru.bellintegrator.myproject.utils.ResponseViewData;
import ru.bellintegrator.myproject.utils.ResponseViewError;
import java.util.logging.Logger;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/user", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;
    protected static Logger logger = Logger.getLogger(UserControllerImpl.class.getName());

    @Autowired
    public UserControllerImpl(UserService usersService) {
        this.userService = usersService;
    }


    @ApiOperation(value = "allUser", nickname = "allUser", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public Response list(@RequestBody UserFilterView view) {
        try {
            if(view.officeId == null) throw new ControllerException();
            Object data = userService.list(view);

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
    @ApiOperation(value = "getUser", nickname = "getUser", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public Response getUserById(@PathVariable Long id) {
        try {
            if(id == null) throw new ControllerException();
            Object data = userService.getUserById(id);
            logger.info("User get ID:" + id);

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
    @ApiOperation(value = "updateUser", nickname = "updateUser", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public Response update(@RequestBody UserView view) {

        try {
            if(view.id == null) throw new ControllerException();
            userService.update(view);
            logger.info("User update " + view.toString());

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
    @ApiOperation(value = "saveUser", nickname = "saveUser", httpMethod = "POST")
    @RequestMapping(value = "/save", method = {POST})
    public Response save(@RequestBody UserView view) {

        try {
            logger.info("User save " + view.toString1());
            userService.save(view);

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
    @ApiOperation(value = "deleteUser", nickname = "deleteUser", httpMethod = "DELETE")
    @RequestMapping(value = "/{id}", method = {DELETE})
    public Response delete(@PathVariable Long id) {

        try {
            if(id == null) throw new ControllerException();
            userService.delete(id);
            logger.info("User get ID:" + id);
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

