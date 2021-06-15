#_WILDLIFE TRACKER_

#### _Web app that allows any user to post wildlife sightings_

#### Author - _**Isaac Kaptoge**_

## Languages used
- Java
- PostgreSQL
- Spark framework

## Description
_This web application intakes user data about wildlife sightings in their area to store and display data about endangered animals. It utilizes Java, PostgreSQL, Spark framework, and Gradle Build Tool._

## Setup / Installation Requirements
- Git clone my repository .
- Open using your local machine the project .

#### Database Setup
_Start postrgres in your terminal by running psql._
_Once psql is running entre the following to set up the tables:_
* _CREATE DATABASE wildlife_tracker;_
* _\c wildlife_tracker;_
* _CREATE TABLE animals (id SERIAL PRIMARY KEY, name VARCHAR, endangered VARCHAR, health VARCHAR, age VARCHAR);_
* _CREATE TABLE sightings(id SERIAL PRIMARY KEY, ranger VARCHAR, animal_id INT, location VARCHAR, dateTime TIMESTAMP);_
* _CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;_

#### Running the application
* _Navigate to the app the open the terminal and run : gradle run._
* _Go to your browser and search for localhost 4567 ;_
## Known Bugs
* _Theres no record of the time of the sighting but all this will be updated in future release ._

## Support & Contact details
_If you have any questions feel free to reach out to me at ikaptoge@yahoo.com_

### License
Copyright (c) 2021 **_Isaac Kaptoge_**

*Licensed under MIT license *