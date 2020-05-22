package com.larkea.openapi.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "创建产品", description = "产品")
public class ProductCreateParam {

    @ApiModelProperty(value = "产品名称")
    @NotBlank
    @Length(min = 4, max = 30)
    private String name;

    @ApiModelProperty(value = "产品描述")
    private String description;

    @ApiModelProperty(value = "节点类型")
    @NotNull
    private NodeType nodeType;

    @ApiModelProperty(value = "连网方式")
    private NetType netType;

    @ApiModelProperty(value = "子设备连接网关方式")
    private GwNetType gwNetType;

    @ApiModelProperty(value = "数据格式")
    @NotNull
    private DataFormat dataFormat;

}
