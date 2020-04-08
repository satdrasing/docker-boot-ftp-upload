# docker-boot-ftp-upload

```
docker-compose up -d

curl -i -X POST -H 'Content-Type: multipart/form-data'  -F 'file=@/home/satendra/Documents/arch-installation' http://localhost:8080/upload

HTTP/1.1 201 
Location: http://localhost:8080/upload
Content-Length: 0
Date: Wed, 08 Apr 2020 10:03:57 GMT

```