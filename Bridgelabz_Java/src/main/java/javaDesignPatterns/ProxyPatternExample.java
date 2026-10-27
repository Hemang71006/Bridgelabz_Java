package javaDesignPatterns;

/**
 * Problem: Create a FileService interface, a RealFileService class,
 * and a FileAccessProxy that checks the user's role before allowing
 * access to the real file service.
 *
 * Author : Hemang
 * Date   : 22-10-2026
 */

public class ProxyPatternExample {

    // Define the common file access operation.
    interface FileService {
        void openFile(String fileName, String role);
    }

    // Perform the actual file operation.
    static class RealFileService implements FileService {
        // Open the requested file.
        public void openFile(String fileName, String role) {
            System.out.println("Opening file: " + fileName);
        }
    }

    // Control access to the real file service.
    static class FileAccessProxy implements FileService {
        private RealFileService realFileService = new RealFileService();

        // Check the user's role before allowing file access.
        public void openFile(String fileName, String role) {
            // Allow access only to users with the admin role.
            if ("admin".equalsIgnoreCase(role)) {
                realFileService.openFile(fileName, role);
            } else {
                // Deny access to other users.
                System.out.println("Access denied for role: " + role);
            }
        }
    }

    // Test the Proxy pattern.
    public static void main(String[] args) {
        // Create the proxy instead of accessing the real service directly.
        FileService fileService = new FileAccessProxy();

        // Attempt access as an admin.
        fileService.openFile("report.txt", "admin");

        // Attempt access as a regular user.
        fileService.openFile("report.txt", "user");
    }
}
