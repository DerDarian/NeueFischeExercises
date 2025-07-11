package org.example.Ecosystem;

public enum DaysOfWeek {

    MONDAY("Montag"),
    TUESDAY("Dienstag"),
    WEDNESDAY("Mittwoch"),
    THURSDAY("Donnerstag"),
    FRIDAY("Freitag"),
    SATURDAY("Samstag"),
    SUNDAY("Sonntag");

    final String weekday;

    public String getWeekday(){
        if(this.equals(SATURDAY) || this.equals(SUNDAY)){
            return "Wochenende";
        }
        return weekday;
    }

    DaysOfWeek(String weekday) {
        this.weekday = weekday;
    }

}
