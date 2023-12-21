<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*, java.util.List, java.util.ArrayList, doctor_management.Doctor" %>
<% 
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false", "root", "root");

    String selectQuery = "SELECT * FROM Doctors";
    PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
    ResultSet resultSet = preparedStatement.executeQuery();

    List<Doctor> doctors = new ArrayList<>();

    while (resultSet.next()) {
        int id = resultSet.getInt("doctor_id");
        String fname = resultSet.getString("first_name");
        String lname = resultSet.getString("last_name");
        String contactno = resultSet.getString("contact_no");
        String specialization = resultSet.getString("specialization");
        String email = resultSet.getString("email");

        Doctor doctor = new Doctor(id, fname, lname, contactno, specialization, email);
        doctors.add(doctor);
    }

    con.close();

    request.setAttribute("doctors", doctors);
} catch (Exception e) {
    e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Management</title>
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script>
        function toggleForm() {
            var form = document.getElementById("doctorForm");
            form.style.display = (form.style.display === 'none' || form.style.display === '') ? 'block' : 'none';
        }

        function toggleUpdateDoctorForm(doctorId, firstName, lastName, contactNo, specialization, email) {
            var updateDoctorForm = document.getElementById("updateDoctorForm");
            updateDoctorForm.style.display = 'block';
            document.getElementById("updateDoctorId").value = doctorId;
            document.getElementById("updateFirstName").value = firstName;
            document.getElementById("updateLastName").value = lastName;
            document.getElementById("updateContactNo").value = contactNo;
            document.getElementById("updateSpecialization").value = specialization;
            document.getElementById("updateEmail").value = email;
        }
    </script>
</head>
<body>
    <div class="container">
        <h1 class="mt-3">Doctor Management</h1>

        <!-- Add Doctor Section -->
        <div class="mt-3">
            <button class="btn btn-primary" onclick="toggleForm()">Add Doctor</button>
			  <form id="doctorForm" action="AddDoctorServlet" method="post" style="display: none;">
			    <div class="form-group">
			        <label for="firstName">First Name:</label>
			        <input type="text" class="form-control" name="firstName" id="firstName" required>
			    </div>
			    <div class="form-group">
			        <label for="lastName">Last Name:</label>
			        <input type="text" class="form-control" name="lastName" id="lastName" required>
			    </div>
			    <div class="form-group">
			        <label for="contactNo">Contact No:</label>
			        <input type="text" class="form-control" name="contactNo" id="contactNo" required pattern="[0-9]{10}">
			        <small class="form-text text-muted">Please enter a valid contact number (digits only).</small>
			    </div>
			    <div class="form-group">
			        <label for="specialization">Specialization:</label>
			        <input type="text" class="form-control" name="specialization" id="specialization" required pattern="[A-Za-z]+">
			    </div>
			    <div class="form-group">
			        <label for="email">Email:</label>
			        <input type="email" class="form-control" name="email" id="email" >
			    </div>
			    <button type="submit" class="btn btn-success">Submit</button>
			</form>
        </div>

        <!-- Update Doctor Section -->
        <div class="mt-3">
            <form id="updateDoctorForm" action="UpdateDoctorServlet" method="post" style="display: none;">
                <div class="form-group">
                    <label for="updateDoctorId">Doctor ID to Update:</label>
                    <input type="text" class="form-control" name="doctorId" id="updateDoctorId" readonly>
                </div>
                <div class="form-group">
                    <label for="updateFirstName">First Name:</label>
                    <input type="text" class="form-control" name="firstName" id="updateFirstName">
                </div>
                <div class="form-group">
                    <label for="updateLastName">Last Name:</label>
                    <input type="text" class="form-control" name="lastName" id="updateLastName">
                </div>
                <div class="form-group">
                    <label for="updateContactNo">Contact No:</label>
                    <input type="text" class="form-control" name="contactNo" id="updateContactNo" pattern="[0-9]{10}">
                </div>
                <div class="form-group">
                    <label for="updateSpecialization">Specialization:</label>
                    <input type="text" class="form-control" name="specialization" id="updateSpecialization" pattern="[A-Za-z]+">
                </div>
                <div class="form-group">
                    <label for="updateEmail">Email:</label>
                    <input type="text" class="form-control" name="email" id="updateEmail" pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}">
                </div>
                <button type="submit" class="btn btn-primary">Update Doctor</button>
            </form>
        </div>

        <!-- Doctor Details Table -->
        <h1 class="mt-3">Doctor Details</h1>
        <table class="table table-bordered mt-3">
            <thead class="thead-light">
                <tr>
                    <th>Doctor ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Contact Number</th>
                    <th>Specialization</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${doctors}" var="doctor">
                    <tr>
                        <td>${doctor.id}</td>
                        <td>${doctor.fname}</td>
                        <td>${doctor.lname}</td>
                        <td>${doctor.contactno}</td>
                        <td>${doctor.specialization}</td>
                        <td>${doctor.email}</td>
                        <td>
                            <form action="DeleteDoctorServlet" method="post">
                                <input type="hidden" name="doctorIdToDelete" value="${doctor.id}">
                                <button type="submit" class="btn btn-danger">Delete</button>
                            </form>
                            <button class="btn btn-primary mt-2" onclick="toggleUpdateDoctorForm('${doctor.id}', '${doctor.fname}', '${doctor.lname}', '${doctor.contactno}', '${doctor.specialization}', '${doctor.email}')">Update</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>