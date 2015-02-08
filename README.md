======================================================================
dbutil sample
======================================================================

Build and test
--------------
```bash
ant clean build test
```

MySQL: boot2docker container
----------------------------
1. install boot2docker
2. read and follow instructions in etc/docker/README.md

MySQL JDBC sample
-----------------
1. edit build.xml to change MySQL host address(HOST)
```
<jvmarg value="-DHOST=192.168.59.103" /> 
``` 
2.
```bash
# sh etc/initialize_db.sh
ant build runjdbc
```

output
```
runjdbc:
     [java] hoge
```

----
Takashi Masuyama <mamewotoko@gmail.com>
