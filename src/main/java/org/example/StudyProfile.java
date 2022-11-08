package org.example;

public enum StudyProfile {
    engineer("инженер"),
    designer("дизайнер"),
    interpreter("переводчик"),
    medicine("медицина"),
    history("история")
    ;

    String profileName;

    StudyProfile(String profileName) {
            this.profileName = profileName;
        }

    StudyProfile() {
        }
    }
