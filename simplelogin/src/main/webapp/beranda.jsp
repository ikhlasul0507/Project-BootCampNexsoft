
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

img{
    width:100%;
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
    <img src="https://wallpapercave.com/wp/wp3417099.jpg">
</body>
</html>
