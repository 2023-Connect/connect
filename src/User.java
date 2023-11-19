import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
        private static final long serialVersionUID = 1L;

        private String userId;
        private String nationality1;
        private String nationality2;
        private String nationality3;
        private String userLanguage;
        private int userBirthYear;
        private int userBirthMonth;
        private int userBirthDay;
        private String userGender;

        public User(String userId, String userName, String userPassword, String nationality1,
                    String nationality2, String nationality3, String userLanguage,
                    int userBirthYear, int userBirthMonth, int userBirthDay, String userGender) {
            this.userId = userId;
            this.username = userName;
            this.password = userPassword;
            this.nationality1 = nationality1;
            this.nationality2 = nationality2;
            this.nationality3 = nationality3;
            this.userLanguage = userLanguage;
            this.userBirthYear = userBirthYear;
            this.userBirthMonth = userBirthMonth;
            this.userBirthDay = userBirthDay;
            this.userGender = userGender;
        }

        // Getters and setters (generated automatically or manually)

        @Override
        public String toString() {
            return "User{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + username + '\'' +
                    ", userPassword='" + password + '\'' +
                    ", nationality1='" + nationality1 + '\'' +
                    ", nationality2='" + nationality2 + '\'' +
                    ", nationality3='" + nationality3 + '\'' +
                    ", userLanguage='" + userLanguage + '\'' +
                    ", userBirthYear='" + userBirthYear + '\'' +
                    ", userBirthMonth='" + userBirthMonth + '\'' +
                    ", userBirthDay='" + userBirthDay + '\'' +
                    ", userGender='" + userGender + '\'' +
                    '}';
        }

}