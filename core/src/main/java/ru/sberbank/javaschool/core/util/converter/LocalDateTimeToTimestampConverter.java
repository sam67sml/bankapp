package ru.sberbank.javaschool.core.util.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * JavaSchool SBT
 * Created by Sam on 26.12.2016.
 */
@Converter
public class LocalDateTimeToTimestampConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime localDate) {
        return localDate == null ? null:Timestamp.valueOf(localDate);
    }

    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

}
