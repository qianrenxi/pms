package org.qianrenxi.core.common.spring.support;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DateConvert implements Converter<String, Date> {
	private static String[] parsePatterns = {
			"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "HH:mm:ss", "HH:mm",
			"yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
			"yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			if(NumberUtils.isCreatable(source)) {
				date = new Date(NumberUtils.createLong(source));
			} else {
				date = DateUtils.parseDate(source, parsePatterns);
			}
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

}
