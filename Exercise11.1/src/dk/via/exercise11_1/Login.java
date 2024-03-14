package dk.via.exercise11_1;

public class Login {
    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Login)) return false;
        Login other = (Login) obj;
        return username.equals(other.username) && password.equals(other.password);
    }

    @Override
    public String toString() {
        return "Login{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
