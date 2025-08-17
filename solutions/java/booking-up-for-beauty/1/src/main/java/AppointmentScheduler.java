import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class AppointmentScheduler {
    private final int ANNIVERSARY_MONTH = 9;
    private final int ANNIVERSARY_DAY = 15;
    
    public LocalDateTime schedule(String appointmentDateDescription) {
        return LocalDateTime.parse(appointmentDateDescription, DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")); 
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime t = appointmentDate.toLocalTime();
        return !t.isBefore(LocalTime.NOON) && t.isBefore(LocalTime.of(18,0));
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("EEEE, MMMM d, uuuu, 'at' h:mm a");
        return "You have an appointment on " + appointmentDate.format(format) + ".";
    }

    public LocalDate getAnniversaryDate() {
        return LocalDate.of(LocalDate.now().getYear(),ANNIVERSARY_MONTH,ANNIVERSARY_DAY);
    }
}
