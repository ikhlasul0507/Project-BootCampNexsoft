

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Membuat Menu Responsive dengan HTML dan CSS</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>

<link href='http://fonts.googleapis.com/css?family=PT+Sans:400,700' rel='stylesheet' type='text/css'>

<style>
/* Clearfix */
.clearfix:before,
.clearfix:after {
    content: " ";
    display: table;
}
.clearfix:after {
    clear: both;
}
.clearfix {
    *zoom: 1;
}

/******************************************************/
/******************** Desain Menu *********************/
/******************************************************/
body {
	background-color: #ece8e5;
}
nav {
	height: 40px;
	width: 100%;
	background: #3498db;
	font-size: 11pt;
	font-family: 'PT Sans', Arial, sans-serif;
	font-weight: bold;
	position: relative;
}
nav ul {
	padding: 0;
	margin: 0 auto;
	width: 500px;
	height: 40px;
}
nav li {
	display: inline;
	float: left;
}
nav a {
	color: #ffffff;
	display: inline-block;
	width: 100px;
	text-align: center;
	text-decoration: none;
	line-height: 40px;
}
nav a:hover, nav a:active {
	background-color: #ecf0f1;
	color: #333;
}
nav a#pull {
	display: none;
}


/******************************************************/
/*************** Desain Menu Responsive ***************/
/******************************************************/

/* Desain untuk perangkat dengan layar 600px kebawah*/
@media screen and (max-width: 600px) {
	nav {
  		height: auto;
  		border-bottom: 0;
  		background: #3498db;
  	}
  	nav ul {
  		width: 100%;
  		display: none;
  		height: auto;
  	}
  	nav li {
  		width: 100%;
  		float: none;
  		display: block;
  		background: #ffffff;
  	}
  	nav li a {
		border-bottom: 1px solid #f0f0f0;
		border-right: 1px solid #f0f0f0;
	}
  	nav a {
	  	text-align: left;
	  	width: 100%;
	  	text-indent: 25px;
	  	color: #333333;
  	}
  	nav a#pull {
		display: block;
		background-color: #3498db;
		width: 100%;
		position: relative;
		color: #ffffff;
	}
	nav a#pull:after {
		content:"";
		background: url('img/nav-icon.png') no-repeat;
		width: 30px;
		height: 30px;
		display: inline-block;
		position: absolute;
		right: 15px;
		top: 10px;
	}
}

* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  margin-top:5px;
  cursor: pointer;
  float: right;
}
.btnEdit{
    background-color: #4CAF50;
      color: white;
      padding: 12px 20px;
      border: none;
      border-radius: 4px;
      margin-top:5px;
      cursor: pointer;
}
.btnHapus{
    background-color: red;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  margin-top:5px;
  cursor: pointer;
}


input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}
.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}

/* Menghapus float setelah kolom */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - Saat layar kurang dari 600px, maka kolom tidak saling bersebelahan */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}

h4{
  font-family: sans-serif;
}

table {
  font-family: Arial, Helvetica, sans-serif;
  color: #666;
  text-shadow: 1px 1px 0px #fff;
  background: #eaebec;
  border: #ccc 1px solid;
}

table th {
  padding: 15px 35px;
  border-left:1px solid #e0e0e0;
  border-bottom: 1px solid #e0e0e0;
  background: #ededed;
}

table th:first-child{
  border-left:none;
}

table tr {
  text-align: center;
  padding-left: 20px;
}

table td:first-child {
  text-align: left;
  padding-left: 20px;
  border-left: 0;
}

table td {
  padding: 15px 35px;
  border-top: 1px solid #ffffff;
  border-bottom: 1px solid #e0e0e0;
  border-left: 1px solid #e0e0e0;
  background: #fafafa;
  background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
  background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
}

table tr:last-child td {
  border-bottom: 0;
}

table tr:last-child td:first-child {
  -moz-border-radius-bottomleft: 3px;
  -webkit-border-bottom-left-radius: 3px;
  border-bottom-left-radius: 3px;
}

table tr:last-child td:last-child {
  -moz-border-radius-bottomright: 3px;
  -webkit-border-bottom-right-radius: 3px;
  border-bottom-right-radius: 3px;
}

table tr:hover td {
  background: #f2f2f2;
  background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
  background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0);
}
</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script>
		$(function() {
			var pull 		= $('#pull'); // Variabel tombol navigasi (akan muncul hanya pada perangkat mobile)
				menu 		= $('nav ul'); // Variabel menu

			$(pull).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});
			$(window).resize(function(){
        		var w = $(window).width();
        		if(w > 600 && menu.is(':hidden')) {
        			menu.removeAttr('style');
        		}
    		});
		});
		$(document).ready(function(){

                        // Format mata uang.
                        $( '.uang' ).mask('000.000.000', {reverse: true});

                    })
	</script>

<body>
    <nav class="clearfix">
        <a href="#" id="pull">Menu</a>
          <ul class="clearfix">
                                      <li><a href="dataKaryawan">Data Karyawan</a></li>
                                      <li><a href="dataJabatan">Data Jabatan</a></li>
                                      <li><a href="tampilKaryawan"target="_blank">List Karyawan</a></li>
                                      <li><a href="tampilJabatan" target="_blank">List Jabatan</a></li>
                                      <li><a href="keluar" onClick="return confirm('Yakin Keluar ?')
                                                                                                                  ">Keluar</a></li>
                       </ul>

    </nav>

    <div class="container">
       <form method="post" action="inputDataJabatan">
      <div class="row">
        <div class="col-25">
          <label for="nama_depan">Nama Jabatan</label>
        </div>
        <div class="col-75">
          <input type="text" id="nama_jabatan" name="namaJabatan" placeholder="Nama Jabatan..." required>
        </div>
      </div>
      <div class="row">
        <div class="col-25">
          <label for="nama_belakang">Tunjangan Makan</label>
        </div>
        <div class="col-75">
          <input type="text" id="nama_belakang" name="tunjanganMakan" placeholder="Tunjangan Makan.." required>
        </div>
      </div>
      <div class="row">
              <div class="col-25">
                <label for="nama_belakang">Tunjangan Transport</label>
              </div>
              <div class="col-75">
                <input type="text" id="nama_belakang" name="tunjanganTransport" placeholder="Tunjangan Transport.." required>
              </div>
            </div>

        <input type="submit" value="Submit">
      </div>
      </form>
    </div>
    <div>
    <center>
    <h4>HASIL INPUT DATA JABATAN</h4>
    		<%@page import="java.sql.*" %>
                 <%@page import="java.io.*" %>
                 <html>
                 <head>
                 <title>Display data from MySQL</title>
                 </head>
                 <body>
                 <%
                 try {

                //deklarasi url database
                 String url = "jdbc:mysql://localhost:3306/db_latihan10";
                 Connection con = null;
                 Statement stat = null;
                 ResultSet rs = null;

                //load jdbc driver
                 Class.forName("com.mysql.jdbc.Driver").newInstance();

                con = DriverManager.getConnection(url, "root", "ABcd//12");

                stat = con.createStatement();

                //membuat query
                 String query = "Select * from tbl_jabatan";

                rs = stat.executeQuery(query);

                %>
                 <table border="1">
                 <tr>
                 <th>ID Jabatan</th>
                 <th>Nama Jabatan</th>
                 <th>Tunjangan Makan</th>
                 <th>Tunjangan Transport</th>
                 <th>Aksi</th>
                 </tr>
                 <% while (rs.next())
                 {
                 %>
                 <tr>
                 <td><%=rs.getString(1)%></td>
                 <td><%=rs.getString(2)%></td>
                 <td><%=rs.getString(3)%></td>
                 <td><%=rs.getString(4)%></td>
                 <td>
                    <a href="updateJabatan.jsp?id=<%=rs.getString(1)%>" class="btnEdit">Edit</a>
                    <a href="deleteJabatan.jsp?id=<%=rs.getString(1)%>" onClick="return confirm('Yakin Keluar ?')" class="btnHapus">Hapus</a>
                 </td>
                 </tr>

                <%
                 }
                 %>
                 <%

                //menutup koneksi
                 rs.close();
                 stat.close();
                 con.close();
                 }
                 catch (Exception ex)
                 {
                 out.println ("Unable to connect to database");
                 }
                 %>
                 </table>
    </div>
</body>
</html>



