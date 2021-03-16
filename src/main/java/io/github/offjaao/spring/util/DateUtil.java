package io.github.offjaao.spring.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtil {

    public String formatLocalDateTime(LocalDateTime e) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(e);
    }

}
