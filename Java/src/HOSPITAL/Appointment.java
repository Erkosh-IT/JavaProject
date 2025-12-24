package HOSPITAL;

public class Appointment {

    private int appointmentId;
    private String date;
    private String time;
    private String status;

    public Appointment(int appointmentId, String date, String time, String status) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Appointment() {
        this.appointmentId = 0;
        this.date = "Unknown";
        this.time = "Unknown";
        this.status = "Scheduled";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void cancelAppointment() {
        this.status = "Cancelled";
    }

    public boolean isActive() {
        return status.equalsIgnoreCase("Scheduled");
    }

    @Override
    public String toString() {
        return "Appointment{id=" + appointmentId + ", date='" + date +
                "', time='" + time + "', status='" + status + "'}";
    }
}

