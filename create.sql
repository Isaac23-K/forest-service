CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE  animals(id SERIAL PRIMARY KEY, name VARCHAR, endangered VARCHAR, health VARCHAR, age VARCHAR);
CREATE TABLE sighting(id SERIAL PRIMARY KEY, ranger VARCHAR, animal_id INT, location VARCHAR, dateTime TIMESTAMP);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
\q