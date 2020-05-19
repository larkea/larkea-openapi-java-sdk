package com.larkea.openapi.util;

import com.larkea.openapi.thing.PropertyInfo;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * 物模型属性解析器
 */
@Slf4j
@UtilityClass
public class PropertyInfoUtil {

	/**
	 * 解析 int32/int4 数据
	 *
	 * @return 解析后的 Long 值
	 */
	public static Long parseInt(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseInt(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 解析 float32/float64 类型数据
	 *
	 * @return 解析后的 Double 值
	 */
	public static Double parseFloat(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseFloat(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 解析 bool 类型数据
	 * <p>
	 * value 被 parse 成 Long 后再进行判断
	 *
	 * @return null 返回 null, 0 返回 false， 其它都返回 true
	 */
	public static Long parseBool(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseEnum(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 解析 enum 类型数据
	 * <p>
	 * value 被 parse 成 Long 后再返回
	 *
	 * @return 返回物模型定义的枚举值之一
	 */
	public static Long parseEnum(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseEnum(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 解析字符串, 超过长度的部分，会被删除
	 *
	 * @return 返回规定长度的字符串
	 */
	public static String parseString(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseString(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 解析时间类型
	 *
	 * @return 返回毫秒值，一定为非负数
	 */
	public static Long parseDate(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parseDate(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

	/**
	 * 自动解析支持的类型.
	 */
	public static Object parse(PropertyInfo propertyInfo, Object value) {
		return SpecUtil.parse(propertyInfo.getSpec(), propertyInfo.getDataType(), value);
	}

}
