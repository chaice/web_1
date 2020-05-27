import com.ccit.bean.AppName;
import com.ccit.bean.UserBean;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static List<AppName> appNameList = new LinkedList<>();

    private static char value[];

    public static void main(String[] args) throws Exception {
        System.out.println(12030%255);
    }

    public static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static int indexOf(char[] source, int sourceOffset, int sourceCount,
                               char[] target, int targetOffset, int targetCount,
                               int fromIndex) {
        if (fromIndex >= sourceCount) {
            return (targetCount == 0 ? sourceCount : -1);
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (targetCount == 0) {
            return fromIndex;
        }

        char first = target[targetOffset];
        int max = sourceOffset + (sourceCount - targetCount);

        for (int i = sourceOffset + fromIndex; i <= max; i++) {
            if (source[i] != first) {
                while (++i <= max && source[i] != first) ;
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = targetOffset + 1; j < end && source[j]
                        == target[k]; j++, k++)
                    ;

                if (j == end) {
                    return i - sourceOffset;
                }
            }
        }
        return -1;
    }

//    public static void main(String[] args) throws Exception {
//        File file = new File("src/main/resources/cn.json");
//        String content = FileUtils.readFileToString(file, "utf-8");
//        JSONObject jsonObject = new JSONObject(content);
//
//        handleChildren("", jsonObject);
//
//        ExcelExportUtil.export(appNameList);
//    }

    private static void handleChildren(String parentPath, JSONObject childrenObject) throws Exception {
        //没有子节点时
        if (!childrenObject.has("children")) {
            AppName appName = new AppName(childrenObject.getString("appname"), parentPath + "/" + childrenObject.getString("appname"));
            appNameList.add(appName);
        } else {
            parentPath += "/" + childrenObject.getString("appname");
            JSONArray childrenArray = (JSONArray) childrenObject.get("children");

            for (int i = 0; i < childrenArray.length(); i++) {
                JSONObject jsonObject = childrenArray.getJSONObject(i);
                handleChildren(parentPath, jsonObject);
            }
        }
    }
}
