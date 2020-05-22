package com.larkea.openapi.product;

import java.time.LocalDateTime;

import com.larkea.boot.core.data.BaseData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品
 * </p>
 *
 * @author wangle
 * @since 2020-01-01
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "Product", description = "产品")
public class Product implements BaseData {

    @ApiModelProperty(value = "产品主键")
    private Long id;

    @ApiModelProperty(value = "租户主键")
    private Long tenantId;

    @ApiModelProperty(value = "产品标识")
    private String productKey;

    @ApiModelProperty(value = "产品名称")
    private String name;

    @ApiModelProperty(value = "产品描述")
    private String description;

    @ApiModelProperty(value = "产品状态")
    private ProductStatus status;

    @ApiModelProperty(value = "是否通过设备密钥动态注册")
    private Boolean dynamicRegister;

    @ApiModelProperty(value = "节点类型")
    private NodeType nodeType;

    @ApiModelProperty(value = "认证类型")
    private AuthType authType;

    @ApiModelProperty(value = "连网方式")
    private NetType netType;

    @ApiModelProperty(value = "连接网关方式")
    private GwNetType gwNetType;

    @ApiModelProperty(value = "数据格式")
    private DataFormat dataFormat;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreated;
}
