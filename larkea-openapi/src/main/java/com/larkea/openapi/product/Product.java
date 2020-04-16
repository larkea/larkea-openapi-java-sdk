package com.larkea.openapi.product;

import com.huitongio.pete.core.data.BaseData;
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
 * @since 2019-12-25
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "产品", description = "产品")
public class Product implements BaseData {

  private static final long serialVersionUID = 1L;

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

  @ApiModelProperty(value = "节点类型")
  private NodeType nodeType;


}
