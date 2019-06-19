package com.didispace.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author dell
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户基本信息",description = "用户基本信息")
public class User implements Serializable {

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty("姓名")
    @Size(max = 20)
    private String name;

    @ApiModelProperty(value = "年龄")
    @Max(150)
    @Min(1)
    private Long age;

    @NotNull
    private String address;

    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")
    private String email;

}