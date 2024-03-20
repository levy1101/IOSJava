import java.io.*;

public class FileSize {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Nhập đường dẫn của file:");
            String filePath = reader.readLine();

            File file = new File(filePath);
            if (file.exists()) {
                long fileSize = file.length();
                System.out.println("Độ lớn của file là: " + fileSize + " bytes");
            } else {
                System.out.println("File không tồn tại hoặc đường dẫn không hợp lệ.");
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc dữ liệu từ bàn phím.");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
