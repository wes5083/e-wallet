# e-wallet
Implement e-wallet with REST API to create it, top it up, check its balance and withdraw funds using Springboot &amp; react

## backend java project

### main function 
EWalletApplication.java direct run, default built-in h2 DB 

### main interface
#### regist user 		http://localhost:8080/api/users/register
#### login  			http://localhost:8080/api/users/login
#### open wallet 		http://localhost:8080/api/wallets/open
#### top up	wallet		http://localhost:8080/api/wallets/topUp
#### withdraw wallet	http://localhost:8080/api/wallets/withdraw
#### query wallet		http://localhost:8080/api/wallets/{userId}

## frontend

### yarn install
download the dependences

### yarn start
start the server

### access UI by url
http://localhost:9000

![image](https://user-images.githubusercontent.com/67679233/226291913-10240b00-6c50-4689-a31e-8a34c4d540d6.png)

