<?php

    // Prepare variables for database connection
   
    $dbusername = "alertfarmAdmin@alertfarm"; 
    $dbpassword = "alertfarm/879Contrasena";  
    $server = "alertfarm.mysql.database.azure.com"; 

    $dbconnect = mysqli_connect($server, $dbusername, $dbpassword, "alertfarm");

    // Prepare the SQL statement
	
	$Arduino_idArduino = (int)$_GET["idArduino"];
	$valorGet = floatval($_GET["valor"]);
	$date = date_create();
	$date_Integer = (int)date_timestamp_get($date);
	$Clientes_idClientes = (int)$_GET["idClientes"];
	


    $sql = "INSERT INTO `humedades` (`idParametro`, `valor`, `fecha`, `Clientes_idClientes`, `Arduino_idArduino`) 
                VALUES (NULL, $valorGet, $date_Integer, $Clientes_idClientes, $Arduino_idArduino);";    

    // Execute SQL statement

    mysqli_query($dbconnect, $sql);

    mysqli_close($dbconnect);
	// http://alertfarm.000webhostapp.com/AlertFarm/setHumedad.php?idArduino=1&valor=10&idClientes=1013622878
?>