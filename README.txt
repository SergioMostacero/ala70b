Instalación de maven mediante https://maven.apache.org/download.cgi
Exportar zip en C:\Program Files\
Editar variables de entorno:
    Variables del sistema, busca y selecciona Path, luego haz clic en Editar.
    Agrega la ruta de la carpeta bin de Maven (C:\Program Files\Apache\Maven\bin)

En la raíz del proyecto desde la terminar ejecutar 'mvn clean install' para compilar todas las dependencias del pom

Crear imagenes y contenedores de Docker:
    En la terminal desd la raíz del proyecto = 'docker-compose up --build' 