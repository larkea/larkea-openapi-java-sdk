package com.larkea.openapi.product;

import com.huitongio.pete.core.data.PageQueryParam;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductPageQueryParam extends PageQueryParam {

	private String name;

	private String productKey;

}
