package doctor_management;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewDoctorsServlet")
public class ViewDoctorsServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Use try-with-resources to manage resources
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false", "root", "root");

            String selectQuery = "SELECT * FROM Doctors";
            PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Doctor> doctors = new ArrayList<>();

            while (resultSet.next()) {
                int doctorId = resultSet.getInt("doctor_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String contactNo = resultSet.getString("contact_no");
                String specialization = resultSet.getString("specialization");
                String email = resultSet.getString("email");

                Doctor doctor = new Doctor(doctorId, firstName, lastName, contactNo, specialization, email);
                doctors.add(doctor);
            }

            con.close();

            request.setAttribute("doctors", doctors);
            RequestDispatcher rd = request.getRequestDispatcher("view-doctors.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
