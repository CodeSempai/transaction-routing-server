# transaction-routing-server

git clone https://github.com/tonybricheff/transaction-routing-server.git

npm install

sudo mysql --password

create database TransactionRouting;

create user 'springuser_'@'%' identified by 'ThQwerty';

grant all on TransactionRouting.* to 'springuser_'@'%';

run db.sql scripts

./mvnw spring-boot:run

go localhost:8080
