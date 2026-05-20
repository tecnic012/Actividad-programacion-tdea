/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.banco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class MongoConfig {

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
            new LocalDateTimeToDateConverter(),
            new DateToLocalDateTimeConverter()
        ));
    }

    @WritingConverter
    static class LocalDateTimeToDateConverter
            implements Converter<LocalDateTime, Date> {

        @Override
        public Date convert(LocalDateTime source) {
            return Date.from(
                source.atZone(ZoneId.systemDefault()).toInstant()
            );
        }
    }

    @ReadingConverter
    static class DateToLocalDateTimeConverter
            implements Converter<Date, LocalDateTime> {

        @Override
        public LocalDateTime convert(Date source) {
            return source.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
        }
    }
}
