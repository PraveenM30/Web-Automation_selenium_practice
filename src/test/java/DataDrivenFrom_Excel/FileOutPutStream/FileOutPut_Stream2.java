package DataDrivenFrom_Excel.FileOutPutStream;

import com.Utils.TestBase;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class FileOutPut_Stream2 extends TestBase {

    public static void main(String[] args) throws IOException {

        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Email", "Password"});
        data.put("2", new Object[]{"1", "pramod@live.com", "123456"});
        data.put("3", new Object[]{"2", "test@gmail.com", "password123"});

        Create_Excel("File1.xlsx", "Sheet 1", data);
    }
}
