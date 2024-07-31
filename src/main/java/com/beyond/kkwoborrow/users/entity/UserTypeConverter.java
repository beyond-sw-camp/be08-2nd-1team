package com.beyond.kkwoborrow.users.entity;

import com.beyond.kkwoborrow.users.entity.UserType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserTypeConverter implements AttributeConverter<UserType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(UserType attribute) {
        return attribute == null ? null : attribute.ordinal() + 1;
    }

    @Override
    public UserType convertToEntityAttribute(Integer dbData) {
        if (dbData == null) return null;
        return UserType.values()[dbData - 1];
    }
}
