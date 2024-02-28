public class Appointment {
    private String patientName;
    private String apptDate;
    private String apptTime;
    private String dentistName;

    // Constructors
    public Appointment(String patientName, String apptDate, String apptTime, String dentistName) {
        this.patientName = patientName;
        this.apptDate = apptDate;
        this.apptTime = apptTime;
        this.dentistName = dentistName;
    }

    // Accessor methods
    public String getPatientName() {
        return patientName;
    }

    public String getApptDate() {
        return apptDate;
    }

    public String getApptTime() {
        return apptTime;
    }

    public String getDentistName() {
        return dentistName;
    }

    // Mutator methods
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setApptDate(String apptDate) {
        this.apptDate = apptDate;
    }

    public void setApptTime(String apptTime) {
        this.apptTime = apptTime;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    // toString method
    @Override
    public String toString() {
        return "Appointment{" +
                "patientName='" + patientName + '\'' +
                ", apptDate='" + apptDate + '\'' +
                ", apptTime='" + apptTime + '\'' +
                ", dentistName='" + dentistName + '\'' +
                '}';
    }
}