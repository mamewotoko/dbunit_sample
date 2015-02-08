How to start
-------------
1. copy this directory to boot2docker virtual box (e.g. scp them using docker account)
2. build image
```bash
boot2docker ssh
# cd to copied directory
docker build -t mamewotoko/mysql .
```
3. start container and create database named "test"
```
sh rundocker.sh
```
4. configurations
    - mysql port(3306) of container is port forwarded to boot2docker vm 3306
    - database "test" is created
    - root account is permitted to access remotely
