package HOSPITAL;

public class Appointment {

    private int id;
    private String date;
    private String time;
    private String status;


    public Appointment(int id, String date, String time, String status) {
        setId(id);
        setDate(date);
        setTime(time);
        setStatus(status);
    }

    public Appointment() {
        this(1, "Unknown", "Unknown", "Scheduled");
    }

    public int getAppointmentId() {
        return id;
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

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("Invalid ID. Set to 1.");
            this.id = 1;
        }
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Date cannot be empty.");
            this.date = "Unknown";
        }
    }

    public void setTime(String time) {
        if (time != null && !time.trim().isEmpty()) {
            this.time = time;
        } else {
            System.out.println("Time cannot be empty.");
            this.time = "Unknown";
        }
    }

    public void setStatus(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.status = status;
        } else {
            System.out.println("Status cannot be empty. Set to Scheduled.");
            this.status = "Scheduled";
        }
    }

    public void cancelAppointment() {
        this.status = "Cancelled";
    }

    public boolean isActive() {
        return status.equalsIgnoreCase("Scheduled");
    }

    @Override
    public String toString() {
        return "Appointment{id=" + id + ", date='" + date +
                "', time='" + time + "', status='" + status + "'}";
    }
}

