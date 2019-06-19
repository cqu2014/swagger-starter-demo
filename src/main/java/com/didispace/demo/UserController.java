package com.didispace.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.util.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dell
 */
@Api(tags="用户管理")
@RestController
@Slf4j
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping("/users")
    public User create(@RequestBody @Valid User user) {
        log.info("create:input data [{}]", Json.pretty(user));
        return user;
    }

    @ApiOperation("用户详情")
    @GetMapping("/users/{id}")
    public User findById(@PathVariable Long id) {
        return new User(id,"bbb", 51L, "上海", "aaa@bbb.com");
    }

    @ApiOperation("用户列表")
    @GetMapping("/users")
    public List<User> list(@ApiParam(value = "查看第几页",example = "0") @RequestParam Integer pageIndex,
                           @ApiParam(value = "每页多少条",example = "1") @RequestParam Integer pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User(1L,"aaa", 123L, "北京", "aaa@ccc.com"));
        result.add(new User(2L,"bbb", 123L, "广州", "aaa@ddd.com"));
        return result;
    }

    @ApiOperation("用户列表")
    @GetMapping("/users/all")
    public List<User> lists(@ApiParam(value = "查看第几页") @RequestParam Integer pageIndex,
                           @ApiParam(value = "每页多少条") @RequestParam Integer pageSize) {
        List<User> result = new ArrayList<>();
        result.add(new User(2L,"bbb", 123L, "广州", "aaa@ddd.com"));
        result.add(new User(1L,"aaa", 123L, "北京", "aaa@ccc.com"));
        return result;
    }

    @ApiIgnore
    @DeleteMapping("/users/{id}")
    public String deleteById(@PathVariable Long id) {
        return "delete user : " + id;
    }

}