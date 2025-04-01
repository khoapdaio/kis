package vn.khoapd.kis.shared.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

@Slf4j
public class KhoapdCustomUtil {

    private KhoapdCustomUtil() {
    }

    public static String getStackTrace(Throwable e) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        printWriter.close();

        try {
            stringWriter.close();
        } catch (IOException ex) {
            log.error(getMessageEx(ex));
        }

        return stringWriter.toString();
    }

    public static String getMessageEx(Throwable cause) {
        return cause.getMessage();
    }
}
