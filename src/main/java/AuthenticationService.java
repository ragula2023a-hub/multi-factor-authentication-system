public class AuthenticationService {

    private String storedPassword = "admin123";
    private String generatedOTP = "456789";

    public boolean verifyPassword(String password) {
        return storedPassword.equals(password);
    }

    public boolean verifyOTP(String otp) {
        return generatedOTP.equals(otp);
    }

    public boolean authenticate(String password, String otp) {
        if (!verifyPassword(password)) {
            return false;
        }
        return verifyOTP(otp);
    }
}