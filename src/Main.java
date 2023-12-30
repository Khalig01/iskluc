import java.io.OptionalDataException;

public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM_";

    public static void main(String[] args) {
        try {
            check("sky", "1234", "1234");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword) {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине есть запрещенный символ!");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 ти символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20 ти символов");
        }
        if (isStringCorrect(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы");
        }
    }

    private static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (('a' <= ch && ch <= 'z')
                    || ('A' <= ch && ch <= 'Z')
                    || ch == '_') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


        private static boolean isStringCorrect2(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
          if   (!ALLOWED_CHARS.contains(" " +ch )){
                return false;
            }
        }
        return true;
    }
}






