package com.larkea.openapi.product;

import com.huitongio.pete.core.data.BaseData;

import io.swagger.annotations.ApiModel;
import lombok.Data;
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
@Accessors(chain = true)
@ApiModel(value = "ProductCredential", description = "产品密钥")
public class ProductCredential implements BaseData {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long productId;

	private String productKey;

	private String productSecret;

}
