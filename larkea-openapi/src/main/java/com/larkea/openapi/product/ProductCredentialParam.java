package com.larkea.openapi.product;

import com.huitongio.pete.core.model.BaseModel;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 产品密钥
 * </p>
 *
 * @author wangle
 * @since 2019-12-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ProductCredential参数", description = "产品密钥")
public class ProductCredentialParam extends BaseModel<ProductCredential> {

	private Long productId;

	private String productKey;

	private String productSecret;

}
