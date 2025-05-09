Instalación de maven mediante https://maven.apache.org/download.cgi
Exportar zip en C:\Program Files\
Editar variables de entorno:
    Variables del sistema, busca y selecciona Path, luego haz clic en Editar.
    Agrega la ruta de la carpeta bin de Maven (C:\Program Files\Apache\Maven\bin)

En la raíz del proyecto desde la terminar ejecutar 'mvn clean install' para compilar todas las dependencias del pom

Crear imagenes y contenedores de Docker:
    En la terminal desd la raíz del proyecto = 'docker-compose up --build' 





------------------- PRODUCCIÓN EN UBUNTU 22.04 -------------------
ENTRAR AL SERVER
ssh -i "C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\clave.pem" ubuntu@44.212.4.74 (RUTA DONDE ESTE LA CLAVE.PEM)


INICIAR SPRINGBOOT
sudo systemctl start spring-app


DETENER SPRINGBOOT
sudo systemctl stop spring-app


REINICIAR SPRINGBOOT
sudo systemctl restart spring-app


ESTADO SPRINGBOOT
sudo systemctl status spring-app


ACTIVAR INICIO DE APP AUTO AL ENTRAR AL SERVER
sudo systemctl enable spring-app


DESACTIVAR INICIO DE APP AUTO AL ENTRAR AL SERVER
sudo systemctl disable spring-app


LOGS A TIEMPO REAL
sudo journalctl -u spring-app -f


EDITAR ARCHIVO DE CONFIGURACIÓN (NO HARÍA FALTA)
sudo nano /etc/systemd/system/spring-app.service


RECARGAR SERVICIOS SYSTEMD TRAS EDITAR ARCHIVO DE CONFIGURACIÓN 
sudo systemctl daemon-reload


SUBIR NUEVOS ARCHIVOS DEL PROYECTO
scp -i "C:\ruta\de\tu\clave.pem" -r C:\ruta\de\tu\proyecto\* ubuntu@44.212.4.74:/home/ubuntu/TFG_Back_local/


REINICIAR APP
sudo systemctl restart spring-app

------------------------------------------------------------------