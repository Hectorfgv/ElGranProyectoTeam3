<?php
  $destino= "joanvergara99@gmail.com";
  $nombre = $_REQUEST["name"];
  $correo = $_REQUEST["correo"];
  $mensaje = $_REQUEST["mensaje"];
  $contenido = "Nombre: " . $nombre . "\nCorreo: " . $correo . "\nmensaje: " . $mensaje;

  mail($destino, "Contacto", $contenido);

?>