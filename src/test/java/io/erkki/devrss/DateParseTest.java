package io.erkki.devrss;

import static io.erkki.devrss.core.util.DateUtil.toJavaUtil;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import io.erkki.devrss.core.util.DateUtil;

public class DateParseTest {

    @Test
    public void shouldParseGradleDate() {
        assertEquals(toJavaUtil(LocalDate.of(2017, 12, 20)), DateUtil.tryParseGradleDate("Dec 20, 2017"));
    }

    @Test
    public void shouldParseJpaBuddyDate() {
        assertEquals(toJavaUtil(LocalDate.of(2017, 12, 20)), DateUtil.tryParseJpaBuddyDate("December 20, 2017"));
    }

    @Test
    public void shouldParseMavenCentralDate() {
        assertEquals(toJavaUtil(LocalDate.of(2017, 12, 1)), DateUtil.tryParseMavenCentralDate("Dec, 2017"));
    }
}
