package doctor_management;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/UpdateDoctorServlet")
public class UpdateDoctorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get data from the form
        int doctorId = Integer.parseInt(request.getParameter("doctorId")); // The doctor to update
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String contactNo = request.getParameter("contactNo");
        String specialization = request.getParameter("specialization");
        String email = request.getParameter("email");

        String status = "error"; // Default status is error

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false", "root", "root");

            String updateQuery = "UPDATE Doctors SET first_name=?, last_name=?, contact_no=?, specialization=?, email=? WHERE doctor_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, contactNo);
            preparedStatement.setString(4, specialization);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, doctorId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                status = "success"; // Doctor updated successfully
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("status", status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("doctorManagement.jsp");
        dispatcher.forward(request, response);
    }
}
