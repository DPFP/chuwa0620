package org.example;

public class User {
    private String firstName;
    private String email;
    private String phoneNumber;
    private String whatsAppNumber;
    private String preferenceString;
    private Notification preference;

    public User(String firstName, String email, String phoneNumber, String whatsAppNumber, String preference) {
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.whatsAppNumber = whatsAppNumber;
        setPreference(preference);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWhatsAppNumber() {
        return whatsAppNumber;
    }

    public void setWhatsAppNumber(String whatsAppNumber) {
        this.whatsAppNumber = whatsAppNumber;
    }

    public Notification getPreference() {
        return preference;
    }
    public String getPreferenceString() {return preferenceString;}
    public void setPreference(String preference) {
        if (preference == "Email") {
            this.preference = new EmailNotification();
        } else if (preference == "SMS") {
            this.preference = new SMSNotification();
        } else if (preference == "WhatsApp") {
            this.preference = new WhatsAppNotification();
        } else {
            throw new IllegalArgumentException("Please provide accurate preference information, which are one of" +
                    "Email, SMS or WhatsAPP");
        }
        this.preferenceString = preference;
    }
}
