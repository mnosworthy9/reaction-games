# reaction-games
java swing gui games to test reactions


## Create postgreSQL Database 
1. download pgadmin 4 [here](https://www.pgadmin.org/download/)
  - create new database
  - assign user to database
  
2. download driver for PostgreSql from [PostgreSQL Driver](https://jdbc.postgresql.org/download.html)
3. download java 18 if required 
4. add module dependency to postgresql-xx.x.x.jar (File > Project structure > Modules > + > JAR or Directories > postgresql-43.5.0.jar)
5. create data source 
  - View > Tool Window > Database
  - add new > Data source > PostgresSQL > fill in details 
6. click on the Postgresql Driver in the data source page
  - remove the current driver files
  - add a new driver file
  - custom JAR
  - locate your downloaded one from step 2
  
7. copy the url made for it, e.g. jdbc:postgresql://localhost:5432/postgres
