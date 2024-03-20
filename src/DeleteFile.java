import java.io.*;

public class DeleteFile {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Nhập đường dẫn của thư mục hoặc file để xoá:");
            String path = reader.readLine();

            File file = new File(path);
            if (!file.exists()) {
                System.out.println("Thư mục hoặc file không tồn tại.");
                return;
            }

            if (file.isDirectory()) {
                // Nếu là thư mục
                deleteDirectory(file);
            } else {
                // Nếu là file
                if (file.delete()) {
                    System.out.println("Xoá file thành công.");
                } else {
                    System.out.println("Xoá file thất bại.");
                }
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

    private static void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Xoá các thư mục con trước
                    deleteDirectory(file);
                } else {
                    if (file.delete()) {
                        System.out.println("Xoá file " + file.getName() + " thành công.");
                    } else {
                        System.out.println("Xoá file " + file.getName() + " thất bại.");
                    }
                }
            }
        }

        // Xoá thư mục gốc
        if (dir.delete()) {
            System.out.println("Xoá thư mục " + dir.getName() + " thành công.");
        } else {
            System.out.println("Xoá thư mục " + dir.getName() + " thất bại.");
        }
    }
}
