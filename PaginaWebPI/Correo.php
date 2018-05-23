<?php
  $destino= "joanvergara99@gmail.com";

  $nombre = $_REQUEST["name"];
  $correo = $_REQUEST["email"];
  $mensaje= $_REQUEST["message"];
  $contenido = "Nombre: " . $nombre . "\nCorreo: " . $correo . "\nmensaje: " . $mensaje;

  mail($destino, $nombre, $contenido);

?>