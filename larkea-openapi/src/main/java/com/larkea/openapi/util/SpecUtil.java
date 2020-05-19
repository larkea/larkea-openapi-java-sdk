package com.larkea.openapi.util;

import com.huitongio.pete.core.util.CastUtil;
import com.huitongio.pete.core.util.JsonUtil;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Longs;
import com.larkea.openapi.thing.DataType;
import com.larkea.openapi.thing.Spec;
import com.larkea.openapi.thing.spec.EnumSpec;
import com.larkea.openapi.thing.spec.FloatSpec;
import com.larkea.openapi.thing.spec.IntSpec;
import com.larkea.openapi.thing.spec.StringSpec;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import static com.larkea.openapi.thing.DataType.FLOAT32;
import static com.larkea.openapi.thing.DataType.INT32;

/**
 * 物模型数据类型解析器
 */
@Slf4j
@UtilityClass
public class SpecUtil {

	/**
	 * 解析 int32/int4 数据
	 *
	 * @return 解析后的 Long 值
	 */
	public static Long parseInt(Spec spec, DataType dataType, Object value) {
		Long intValue = Longs.tryParse(String.valueOf(value));
		if (intValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		// 判断 INT32 类型上下限
		if (INT32.equals(dataType)) {
			if (intValue < Integer.MIN_VALUE || intValue > Integer.MAX_VALUE) {
				LOGGER.info("Illegal {} value: {} must in [{}, {}]", dataType, intValue,
						Integer.MIN_VALUE, Integer.MAX_VALUE);
				return null;
			}
		}

		IntSpec intSpec = (IntSpec) spec;
		if (intValue < intSpec.getMin()) {
			LOGGER.info("Illegal {} value: {} is less than {}", dataType, intValue, intSpec.getMin());
			return null;
		}
		else if (intValue > intSpec.getMax()) {
			LOGGER.info("Illegal {} value: {} is greater than {}", dataType, intValue, intSpec.getMax());
			return null;
		}

		return intValue;
	}

	/**
	 * 解析 float32/float64 类型数据
	 *
	 * @return 解析后的 Double 值
	 */
	public static Double parseFloat(Spec spec, DataType dataType, Object value) {
		Double floatValue = Doubles.tryParse(String.valueOf(value));
		if (floatValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		// 判断 FLOAT32 类型上下限
		if (FLOAT32.equals(dataType)) {
			if (floatValue < -Float.MAX_VALUE || floatValue > Float.MAX_VALUE) {
				LOGGER.info("Illegal {} value: {} must in [{}, {}]", dataType, floatValue,
						-Float.MAX_VALUE, Float.MAX_VALUE);
				return null;
			}
		}

		FloatSpec floatSpec = (FloatSpec) spec;
		if (floatValue < floatSpec.getMin()) {
			LOGGER.info("Illegal {} value: {} is less than {}", dataType, floatValue, floatSpec.getMin());
			return null;
		}
		else if (floatValue > floatSpec.getMax()) {
			LOGGER.info("Illegal {} value: {} is greater than {}", dataType, floatValue,
					floatSpec.getMax());
			return null;
		}

		return floatValue;
	}

	/**
	 * 解析 bool 类型数据
	 * <p>
	 * value 被 parse 成 Long 后再进行判断
	 *
	 * @return null 返回 null, 0 返回 false， 其它都返回 true
	 */
	public static Long parseBool(Spec spec, DataType dataType, Object value) {
		Long boolValue = Longs.tryParse(String.valueOf(value));

		if (boolValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		return boolValue == 0L ? 0L : 1L;
	}

	/**
	 * 解析 enum 类型数据
	 * <p>
	 * value 被 parse 成 Long 后再返回
	 *
	 * @return 返回物模型定义的枚举值之一
	 */
	public static Long parseEnum(Spec spec, DataType dataType, Object value) {
		Long enumValue = Longs.tryParse(String.valueOf(value));

		if (enumValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		EnumSpec enumSpec = (EnumSpec) spec;
		if (!enumSpec.getProperties().containsKey(String.valueOf(enumValue))) {
			LOGGER.info("Illegal {} value: {}, value must be in {}", dataType, value,
					enumSpec.getProperties().keySet());
			return null;
		}

		return enumValue;
	}

	/**
	 * 解析字符串, 超过长度的部分，会被删除
	 *
	 * @return 返回规定长度的字符串
	 */
	public static String parseString(Spec spec, DataType dataType, Object value) {
		String strValue = String.valueOf(value);

		if (strValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		StringSpec stringSpec = (StringSpec) spec;

		if (strValue.length() > stringSpec.getLength()) {
			int endIndex = stringSpec.getLength() - 1;
			String strValueTruncated = strValue.substring(0, endIndex);
			LOGGER.info("{} value {} is truncated to {}", dataType, strValue, strValueTruncated);
			return strValueTruncated;
		}

		return strValue;
	}

	/**
	 * 解析时间类型
	 *
	 * @return 返回毫秒值，一定为非负数
	 */
	public static Long parseDate(Spec spec, DataType dataType, Object value) {
		Long dateValue = Longs.tryParse(String.valueOf(value));
		if (dateValue == null) {
			LOGGER.info("Illegal {} value: {}", dataType, value);
			return null;
		}

		if (dateValue < 0) {
			LOGGER.info("Illegal {} value: {} can not less than zero(0)", dataType, dateValue);
			return null;
		}

		return dateValue;
	}

	/**
	 * 自动解析支持的类型.
	 */
	public static Object parse(Spec spec, DataType dataType, Object value) {
		switch (dataType) {
			case INT32:
			case INT64:
				return parseInt(spec, dataType, value);
			case FLOAT32:
			case FLOAT64:
				return parseFloat(spec, dataType, value);
			case BOOL:
				return parseBool(spec, dataType, value);
			case ENUM:
				return parseEnum(spec, dataType, value);
			case STRING:
				return parseString(spec, dataType, value);
			case DATE:
				return parseDate(spec, dataType, value);
			default:
				LOGGER.info("Unsupported dataType={}, spec={}, value={}", dataType, spec, value);
				return null;
		}
	}

	public static <T extends Spec> T craftSpecFromJson(String json, Class<T> clazz) {
		return JsonUtil.fromJson(json, clazz);
	}

	public static <T extends Spec> T craftSpecFromJson(String json, DataType dataType) {
		return CastUtil.cast(JsonUtil.fromJson(json, dataType.getSpecClass()));
	}

}
