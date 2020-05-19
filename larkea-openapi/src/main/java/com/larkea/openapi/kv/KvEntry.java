package com.larkea.openapi.kv;

import com.huitongio.pete.core.data.BaseData;

public interface KvEntry extends BaseData {

	String getKey();

	Object getValue();

	String getValueAsString();

}
