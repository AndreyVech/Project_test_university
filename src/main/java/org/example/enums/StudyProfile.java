package org.example.enums;

public enum StudyProfile {
    ENGINEER("инженер"),
    DESIGNER("дизайнер"),
    INTERPRETER("переводчик"),
    MEDICINE("медицина"),
    HISTORY("история"),
    PHYSICS,
    LINGUISTICS,
    MATHEMATICS;




    String profileName;

    StudyProfile(String profileName) {
            this.profileName = profileName;
        }

    StudyProfile() {
        }
    }
