mysql << "EOF"
# too loose setting
grant all privileges on *.* to 'root'@'%' identified by 'password' with grant option;
flush privileges;
EOF
