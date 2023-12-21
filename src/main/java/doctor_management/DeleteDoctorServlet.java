package doctor_management;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;

@WebServlet("/DeleteDoctorServlet")
public class DeleteDoctorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorIdToDelete"));

        String status = "error"; // Default status is error

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false", "root", "root");

            String deleteQuery = "DELETE FROM Doctors WHERE doctor_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, doctorId);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                status = "success"; // Doctor deleted successfully
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
