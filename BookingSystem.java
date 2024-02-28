import java.util.Scanner;
import java.util.ArrayList;

public class BookingSystem {
    private ArrayList<Appointment> appointments;

    public BookingSystem() {
        this.appointments = new ArrayList<>(20);
    }

    public void addAppointments() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter details for appointment " + (i + 1) + " or type 'exit' to finish:");
            
            System.out.println("Enter patient name:");
            String patientName = scanner.nextLine();
            if (patientName.equalsIgnoreCase("exit")) break;

            System.out.println("Enter appointment date (YYYY-MM-DD):");
            String apptDate = scanner.nextLine();

            System.out.println("Enter appointment time (HH:MM):");
            String apptTime = scanner.nextLine();

            System.out.println("Enter dentist name:");
            String dentistName = scanner.nextLine();

            Appointment appointment = new Appointment(patientName, apptDate, apptTime, dentistName);
            appointments.add(appointment);
        }
    }

    public void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public void searchAppointmentsByDate(String date) {
        for (Appointment appointment : appointments) {
            if (appointment.getApptDate().equals(date)) {
                System.out.println(appointment);
            }
        }
    }

    public void cancelAppointment(String patientName, String apptDate) {
        appointments.removeIf(appointment -> appointment.getPatientName().equalsIgnoreCase(patientName) && appointment.getApptDate().equals(apptDate));
    }

    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        bookingSystem.addAppointments();
        bookingSystem.displayAppointments();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a date to search for appointments (YYYY-MM-DD):");
        String searchDate = scanner.nextLine();
        bookingSystem.searchAppointmentsByDate(searchDate);

        System.out.println("Enter patient name and date (YYYY-MM-DD) to cancel an appointment:");
        String patientName = scanner.nextLine();
        String apptDate = scanner.nextLine();
        bookingSystem.cancelAppointment(patientName, apptDate);

        System.out.println("Updated Appointment Schedule:");
        bookingSystem.displayAppointments();
    }
}