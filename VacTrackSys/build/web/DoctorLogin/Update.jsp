<%--
    Project Title
    File name  : VaccinationDB_2
    Date       : Mar 7, 2022, 8:15:11 PM
    Author(s)  : Jaccob Stanton, Elena Miller
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccination Page</title>
        <link rel="stylesheet" href="vac_db.css">
    </head>
    <body>
        <div class="container">
    <div class="title">Vaccination</div>
    <div class="content">
      <form action="/up">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Vaccination ID</span>
            <input type="text" placeholder="Enter Vaccine ID here" required>
          </div>
          <div class="input-box">
            <span class="details">Location</span>
            <input type="text" placeholder="Enter vaccination location here" required>
          </div>
          <div class="input-box">
            <span class="details">Manufacturer</span>
            <input type="text" placeholder="Enter vaccine manufacturer here" required>
          </div>
          <div class="input-box">
            <span class="details">Date</span>
            <input type="text" placeholder="Enter date here">
          </div>
          <div class="input-box">
            <span class="details">Batch Number</span>
            <input type="text" placeholder="Enter batch # here" required>
          </div>
        </div>
        <div class="gender-details">
          <input type="radio" name="gender" id="dot-1">
          <input type="radio" name="gender" id="dot-2">
          <input type="radio" name="gender" id="dot-3">
          <span class="gender-title">Location</span>
          <div class="category">
            <label for="dot-1">
            <span class="dot one"></span>
            <span class="gender">Hospital</span>
          </label>
          <label for="dot-2">
            <span class="dot two"></span>
            <span class="gender">Clinic</span>
          </label>
          <label for="dot-3">
            <span class="dot three"></span>
            <span class="gender">Other</span>
            </label>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Update">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Clear">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Cancel">
        </div>
      </form>
    </div>
  </div>
    </body>
</html>
