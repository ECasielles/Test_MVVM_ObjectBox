package com.mercacortex.testbinding.mvvm.model.db.converter;

import com.mercacortex.testbinding.base.BaseModel;

import org.joda.time.DateTime;

import io.objectbox.converter.PropertyConverter;


public class DateTimeConverter extends BaseModel implements PropertyConverter<DateTime, Long> {

    @Override
    public DateTime convertToEntityProperty(Long databaseValue) {
        return new DateTime(databaseValue);
    }

    @Override
    public Long convertToDatabaseValue(DateTime entityProperty) {
        return entityProperty.getMillis();
    }

}
