package kr.co.kwonshzzang.bookmanager.bookmanager.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import kr.co.kwonshzzang.bookmanager.bookmanager.dto.BookStatus;

//@Converter(autoApply = true)
@Converter
public class BookStatusConverter implements AttributeConverter<BookStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(BookStatus attribute) {
        return attribute.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer dbData) {
        return dbData != null? new BookStatus(dbData) : null;
    }
}
