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
ssh -i "C:\Users\hugoj\Desktop\TFG_Back_local\clave.pem" ubuntu@35.171.18.46 (RUTA DONDE ESTE LA CLAVE.PEM)


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

http://35.171.18.46/api/tripulantes
http://35.171.18.46:8080/api/tripulantes



scp -i "C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\Clave.pem" -r C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\target\api-0.0.1-SNAPSHOT.jar ubuntu@35.171.18.46:/opt/spring-app/
scp -i "C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\Clave.pem" -r C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local/src/main/resources ubuntu@35.171.18.46:/opt/spring-app/
scp -i "C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\Clave.pem" -r C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local/src/main/java ubuntu@35.171.18.46:/opt/spring-app/

sudo rm -rf /var/www/html/front/front-ala70/*
sudo chown -R ubuntu:www-data /var/www/html/front
sudo chmod -R 775 /var/www/html/front
scp -i "C:\Users\CFGS.LAB37_PC\Desktop\TFG_Back_local\Clave.pem" -r C:\Users\CFGS.LAB37_PC\Desktop\TFG_Front_Local\dist\front-ala70 ubuntu@44.212.4.74:/var/www/html/front/
sudo a2enmod rewrite
sudo systemctl restart apache2

