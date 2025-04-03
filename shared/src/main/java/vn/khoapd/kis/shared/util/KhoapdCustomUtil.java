package vn.khoapd.kis.shared.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;
import vn.khoapd.kis.shared.enums.ECommonErrorCode;
import vn.khoapd.kis.shared.exception.CustomRuntimeException;

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

    public static void validateValueString(String value, ECommonErrorCode errorCode) {
        if (value == null || value.isEmpty()) {
            throw new CustomRuntimeException(errorCode);
        }
    }

    public static String getFileExtension(MultipartFile file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return "";
    }
}
