package HOSPITAL;

public class Appointment{
    private int id;
    private String date;
    private String time;
    private String status;

    public Appointment(int id, String date, String time, String status){
        setId(id);
        setDate(date);
        setTime(time);
        setStatus(status);
    }

    public Appointment(){
        this(1, "Unknown", "Unknown", "Scheduled");
    }
    public int getAppointmentId(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) throw new IllegalArgumentException("TIME MUST BE NOT EMPTY");
        this.status = status;
    }

    public void setTime(String time) {
        if (time == null || time.trim().isEmpty()) throw new IllegalArgumentException("TIME MUST BE NOT EMPTY");
        this.time = time;
    }

    public void setDate(String date) {
        if (date == null || date.trim().isEmpty()) throw new IllegalArgumentException("DATE MUST BE NOT EMPTY");
        this.date = date;
    }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID MUST BE > 0");
        this.id = id;
    }

    public void cancelAppointment(){
        this.status = "Cancelled";
    }
    public boolean isActive(){
        return status.equalsIgnoreCase("Scheduled");
    }
    @Override
    public String toString(){
        return "Appointment{id=" + id + ", date='" + date + ", time='" + time + ", status='" + status + "'}";
    }
}
