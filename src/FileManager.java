import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileManager {
    private static final String FILE_PATH = "user_data.txt";
    private static final String CHARSET_NAME = "UTF-8";

    public static void writeUsersToFile(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
             OutputStreamWriter writer = new OutputStreamWriter(oos, CHARSET_NAME)) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Map<String, String> readUserIdPw() {
        Map<String, String> userIdPwMap = new HashMap<>();
        Pattern userIdPattern = Pattern.compile("userId='(.*?)'");
        Pattern passwordPattern = Pattern.compile("userPassword='(.*?)'");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher userIdMatcher = userIdPattern.matcher(line);
                Matcher passwordMatcher = passwordPattern.matcher(line);

                if (userIdMatcher.find() && passwordMatcher.find()) {
                    String userId = userIdMatcher.group(1);
                    String userPassword = passwordMatcher.group(1);
                    userIdPwMap.put("id", userId);
                    userIdPwMap.put("password", userPassword);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("User data file not found. Creating a new one.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading user data from file. Creating a new list.");
        }

        return userIdPwMap;
    }
    public static Map<String, String> readUsersFromFile() {
        Map<String, String> userMap = new HashMap<>();

        Pattern userIdPattern = Pattern.compile("userId='(.*?)'");
        Pattern userNamePattern = Pattern.compile("userName='(.*?)'");
        Pattern passwordPattern = Pattern.compile("userPassword='(.*?)'");
        Pattern nationality1Pattern = Pattern.compile("nationality1='(.*?)'");
        Pattern nationality2Pattern = Pattern.compile("nationality2='(.*?)'");
        Pattern nationality3Pattern = Pattern.compile("nationality3='(.*?)'");
        Pattern userLanguagePattern = Pattern.compile("userLanguage='(.*?)'");
        Pattern userBirthYearPattern = Pattern.compile("userBirthYear='(.*?)'");
        Pattern userBirthMonthPattern = Pattern.compile("userBirthMonth='(.*?)'");
        Pattern userBirthDayPattern = Pattern.compile("userBirthDay='(.*?)'");
        Pattern userGenderPattern = Pattern.compile("userGender='(.*?)'");

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher userIdMatcher = userIdPattern.matcher(line);
                Matcher userNameMatcher = userNamePattern.matcher(line);
                Matcher passwordMatcher = passwordPattern.matcher(line);
                Matcher nationality1Matcher = nationality1Pattern.matcher(line);
                Matcher nationality2Matcher = nationality2Pattern.matcher(line);
                Matcher nationality3Matcher = nationality3Pattern.matcher(line);
                Matcher userLanguageMatcher = userLanguagePattern.matcher(line);
                Matcher userBirthYearMatcher = userBirthYearPattern.matcher(line);
                Matcher userBirthMonthMatcher = userBirthMonthPattern.matcher(line);
                Matcher userBirthDayMatcher = userBirthDayPattern.matcher(line);
                Matcher userGenderMatcher = userGenderPattern.matcher(line);

                if (userIdMatcher.find() && userNameMatcher.find() && passwordMatcher.find()
                        && nationality1Matcher.find() && nationality2Matcher.find() && nationality3Matcher.find()
                        && userLanguageMatcher.find() && userBirthYearMatcher.find()
                        && userBirthMonthMatcher.find() && userBirthDayMatcher.find() && userGenderMatcher.find()) {

                    String userId = userIdMatcher.group(1);
                    String userName = userNameMatcher.group(1);
                    String userPassword = passwordMatcher.group(1);
                    String nationality1 = nationality1Matcher.group(1);
                    String nationality2 = nationality2Matcher.group(1);
                    String nationality3 = nationality3Matcher.group(1);
                    String userLanguage = userLanguageMatcher.group(1);
                    String userBirthYear = userBirthYearMatcher.group(1);
                    String userBirthMonth = userBirthMonthMatcher.group(1);
                    String userBirthDay = userBirthDayMatcher.group(1);
                    String userGender = userGenderMatcher.group(1);

                    userMap.put("userId", userId);
                    userMap.put("userName", userName);
                    userMap.put("password", userPassword);
                    userMap.put("nationality1", nationality1);
                    userMap.put("nationality2", nationality2);
                    userMap.put("nationality3", nationality3);
                    userMap.put("userLanguage", userLanguage);
                    userMap.put("userBirthYear", userBirthYear);
                    userMap.put("userBirthMonth", userBirthMonth);
                    userMap.put("userBirthDay", userBirthDay);
                    userMap.put("userGender", userGender);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("User data file not found. Creating a new one.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error reading user data from file. Creating a new list.");
        }

        return userMap;
    }
}