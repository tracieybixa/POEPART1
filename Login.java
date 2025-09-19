package org.example;

public class Login {

    private String registeredUserName;
    private String registeredPassword;
    private String registeredPhone;

    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        if (username == null || username.length() > 5 || !username.contains("_")) {
            return false;
        }
        return true;
    }

    // Checking if password is strong
    public boolean checkPasswordComplexity(String password) {
        boolean hasUppercase = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+=].*");

        return password.length() >= 8 && hasUppercase && hasSpecialChar && hasNumber;
    }

    // Checking if phone number is valid
    public boolean checkPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^\\+\\d{1,3}\\d{1,10}$");
    }

    // Register the user
    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username not correctly formatted. Please ensure your username contains an underscore and is not more than 5 characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted. Please ensure your password contains at least 8 characters, a capital letter, a number, and a special character.";
        }
        if (!checkPhoneNumber(phoneNumber)) {
            return "Cell phone number is not correctly formatted or does not contain an international code.";
        }

        // Saving details for the correct conditions
        this.registeredUserName = username;
        this.registeredPassword = password;
        this.registeredPhone = phoneNumber;
        return "Username and password successfully captured. User registered successfully!";
    }

    // Checking if login details match the registered details
    public boolean loginUser(String username, String password) {
        return username.equals(this.registeredUserName) && password.equals(this.registeredPassword);
    }

    // Returning a message depending on the login outcome
    public String returnLoginStatus(String username, String password, String firstName, String lastName) {
        if (loginUser(username, password)) {
            return "Welcome, " + firstName + " " + lastName + "! It's great to see you again.";
        } else {
            return "Username or password is incorrect, please try again.";
        }
    }
}