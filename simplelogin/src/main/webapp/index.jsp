
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> <title>Latihan 3</title>
</head>
<style type="text/css">
.container{
height: 500px;
width: 450px;
background-color: white;
border:2px solid #e9ecf7;
border-radius: 2%;
position: absolute;
margin-top: 20px;
margin-left : 35%;
justify-content: center;
}
body{
background-color: white;
}
.header{
display: inline;
}
img{
height: 40px;
width:100px;
justify-content: center; padding-left: 170px; padding-top: 50px }
.judul{
font-family: arial; font-size: 24px;
font-style: bold;
text-align: center; }
.log{
font-style: bold;
font-family: arial; font-size: 16px;
text-align: center; text-shadow: black; }
.isi{
border-radius: 10px; height: 50px;
}
input{
height: 100%;
border-radius: 10px; margin-left: 10px; margin-right: 10px;
width: 93%;
justify-content: center;
border:1px solid #e9ecf7;
font-size: 18px;
}
.input{
width: 100%;
height: 100%;
border:none;
margin-top:8px;
}
.lupa{
font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 16px;
font-style: bold;
margin-left: 10px;
color: blue
}
.ket{
font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 16px;
font-style: bold;
margin-left: 10px;
margin-top: 50px
}
.footer{
margin-top: 120px;
padding-left: 20px;
padding-bottom: 30px; margin-bottom: 50px
}
.buat{
font-family: arial;
font-size: 18px;
color: blue;
}
.bottomleft {
 position: absolute;
 bottom: 8px;
 left: 16px;
 font-size: 18px;
}
.bottomright {
 position: absolute;
 bottom: 8px;
 right: 16px;
 font-size: 18px;
 background-color: #2356fc;  padding-top: 10px;
 padding-right: 20px;
 padding-bottom: 10px;  border-radius: 5px;
 color: white
}
a{
text-decoration: none;
 }
 .con{
 padding-right: 5px;  padding-left: 5px;  padding-bottom: 50px;  padding-top: 5px  }
 .foot{
 display:flex;
 font-size: 12;
 font-family: arial;  color: #868b9e;  text-align: center;   }
 .bkk{
 margin-left: 150px  }
 .bk{
 border: none;
 }
 select{
 border:none;
 background: none;  }
</style>
<body>
<div class="container">
    <div class="con">
        <div class = "header">
            <div>
                <img
                        src="https://www.google.co.id/images/branding/googlelogo/2x/googlelogo_color_160x56dp.png"> </div>
            <div>
                <p class="judul">Login</p>
            </div>
            <div>
                <p class="log">Gunakan Akun Google Anda</p>
                <center>

                </center>
            </div>
        </div>
        <form action="servlet1" method="post">
        <!-- isi -->
        <div class="isi">
            <div class="input">
                <input type="text" placeholder="Username" name="username" required>
            </div>
            <div class="input">
                <input type="password" placeholder="Password" name="userpass" required>
            </div>
            <div>
                <p class="lupa">Lupa Email ?</p>
            </div>
            <div>
                <p class="ket">
                    Bukan komputer Anda? Gunakan mode Tamu untuk login secara  pribadi. <b><a href="">Pelajari selengkapnya</a></b>
                </p>
            </div>
        </div>
        <!-- footer -->
        <div class="footer">
            <div class="bottomleft">
                <p class="buat">Buat Akun</p>
            </div>
            <div >
                <button class="bottomright" type="submit">Berikutnya</button>
            </div>
        </div>

        <form>
    </div>
    <div class="foot">
        <p class="bk">
            <select>
                <option>Afrika</option>
                <option>Afrika</option>
                <option>Afrika</option>
            </select>
        </p>
        <p class="bkk"><small>Version 1.0.1</small></p>
    </div>
</div>
</body>
</html>
