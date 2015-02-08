docker run -d -p 3306:3306 --name=mysql mamewotoko/mysql
sleep 5
sh docker_init_db.sh

