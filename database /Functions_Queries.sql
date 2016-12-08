
-- triggers------------------------------------------------------

-- update weight of cow each time a new weight record is sensed
USE `smartFarm`;

DELIMITER $$

DROP TRIGGER IF EXISTS smartFarm.WeightSensorRecord_AFTER_INSERT$$
USE `smartFarm`$$
CREATE DEFINER = CURRENT_USER TRIGGER `smartFarm`.`WeightSensorRecord_AFTER_INSERT` 
AFTER INSERT ON `WeightSensorRecord` FOR EACH ROW
BEGIN

update Cow set weight = NEW.Ws_Read
where Cow.Id in 
(select Livestock_Id from AnimalSensor where AnimalSensor.Sensor_Id = NEW.Sensor_Id);

update Pig set weight = NEW.Ws_Read
where Pig.Id in 
(select Livestock_Id from AnimalSensor where AnimalSensor.Sensor_Id = NEW.Sensor_Id);

update Livestock set weight = NEW.Ws_Read
where Livestock.Id in 
(select Livestock_Id from AnimalSensor where AnimalSensor.Sensor_Id = NEW.Sensor_Id);
END$$
DELIMITER ;


-- update milk production of cow each time a new record is sensed, get the information of average milk production in a set interval
USE `smartFarm`;

DELIMITER $$

DROP TRIGGER IF EXISTS smartFarm.MilkSensorRecord_AFTER_INSERT$$
USE `smartFarm`$$
CREATE DEFINER = CURRENT_USER TRIGGER `smartFarm`.`MilkSensorRecord_AFTER_INSERT` AFTER INSERT ON `MilkSensorRecord` FOR EACH ROW
BEGIN
update Cow set Milk_Production = (select avg(Ms_Read) from MilkSensorRecord where Ms_Time > Date_Sub(now(), interval 1 minute))
where Cow.Id in 
(select Livestock_Id from AnimalSensor where AnimalSensor.Sensor_Id = NEW.Sensor_Id);
END$$
DELIMITER ;




-- delete alert if the animal is cured
USE `smartFarm`;

DELIMITER $$

DROP TRIGGER IF EXISTS smartFarm.Disease_History_AFTER_INSERT$$
USE `smartFarm`$$
CREATE DEFINER = CURRENT_USER TRIGGER `smartFarm`.`Disease_History_AFTER_INSERT` AFTER INSERT ON `Disease_History` FOR EACH ROW
BEGIN
if NEW.Cured_or_Not = 'cure' then

delete from Alert
where Alert.Sensor_Id in 
(select Sensor_Id from AnimalSensor where AnimalSensor.Livestock_Id = NEW.Livestock_Id);

end if; 

END$$
DELIMITER ;



-- delete sensor in AnimalSensor
-- add into Sensor, after delete
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Sensor_AFTER_DELETE` AFTER DELETE ON `Sensor` FOR EACH ROW
BEGIN
DELETE FROM AnimalSensor WHERE Sensor_Id NOT IN (SELECT Sensor_Id FROM Sensor);
END


-- cows trigger, prevent duplicated id from pig's id and restrict Employee_Id only employee with category of cow 
-- add into cow's table, after insert trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Cow_AFTER_INSERT` AFTER INSERT ON `Cow` FOR EACH ROW
BEGIN
  IF (SELECT Cow.Id FROM Cow INNER JOIN Pig ON Cow.Id=Pig.Id) IS NOT NULL THEN
  SIGNAL SQLSTATE '45000' SET message_text='duplicate id';    
  END IF;
    
  IF( SELECT Employee_Id FROM Cow 
  WHERE Cow.Employee_Id NOT IN(SELECT Id FROM Employee WHERE Category="cow")) IS NOT NULL THEN
  SIGNAL SQLSTATE '45000' SET message_text='error employee id'; 
  END IF;

  INSERT INTO Livestock (Id, Employee_Id, Age, Weight, Gender)
  SELECT Id, Employee_Id, Age, Weight, Gender FROM Cow WHERE Id NOT IN
  (SELECT Id FROM Livestock);

END

-- add into cow's table, after update trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Cow_AFTER_UPDATE` AFTER UPDATE ON `Cow` FOR EACH ROW
BEGIN
  IF( SELECT Employee_Id FROM Cow 
    WHERE Cow.Employee_Id NOT IN(SELECT Id FROM Employee WHERE Category="cow")) IS NOT NULL THEN
    SIGNAL SQLSTATE '45000' SET message_text='error employee id'; 
  END IF;


END

-- add into cow's table, after delete trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Cow_AFTER_DELETE` AFTER DELETE ON `Cow` FOR EACH ROW
BEGIN
delete from Livestock where not exists (select Id  from Pig where pig.Id=Livestock.Id)
and not exists (select Id from Cow where Cow.Id=Livestock.Id);
END


-- pigs trigger, prevent duplicated id from cow's id and restrict Employee_Id only employee with category of pig 
-- add into pig's table, after insert trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Pig_AFTER_INSERT` AFTER INSERT ON `Pig` FOR EACH ROW
BEGIN
  
  IF (SELECT Pig.Id FROM Pig INNER JOIN Cow ON Pig.Id=Cow.Id) IS NOT NULL THEN
  SIGNAL SQLSTATE '45000' SET message_text='duplicate id';    
  END IF;
    
  IF( SELECT Employee_Id FROM Pig 
  WHERE Pig.Employee_Id NOT IN(SELECT Id FROM Employee WHERE Category="pig")) IS NOT NULL THEN
  SIGNAL SQLSTATE '45000' SET message_text='error employee id'; 
  END IF;

  INSERT INTO Livestock (Id, Employee_Id, Age, Weight, Gender)
  SELECT Id, Employee_Id, Age, Weight, Gender FROM Pig WHERE Id NOT IN
  (SELECT Id FROM Livestock);

END

-- add into pig's table, after update trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Pig_AFTER_UPDATE` AFTER UPDATE ON `Pig` FOR EACH ROW
BEGIN
  IF( SELECT Employee_Id FROM Pig 
    WHERE Pig.Employee_Id NOT IN(SELECT Id FROM Employee WHERE Category="pig")) IS NOT NULL THEN
    SIGNAL SQLSTATE '45000' SET message_text='error employee id'; 
  END IF;
END


-- add into pig's table, after delete trigger
USE `smartFarm`;

DELIMITER $$

DROP TRIGGER IF EXISTS smartFarm.Pig_AFTER_DELETE$$
USE `smartFarm`$$
CREATE DEFINER = CURRENT_USER TRIGGER `smartFarm`.`Pig_AFTER_DELETE` AFTER DELETE ON `Pig` FOR EACH ROW
BEGIN
delete from Livestock where not exists (select Id  from Pig where pig.Id=Livestock.Id)
and not exists (select Id from Cow where Cow.Id=Livestock.Id);
END$$
DELIMITER ;



-- check livestock id mapped to sensor id exists, if not, aborting adding sensor
-- add into sensor's table after insert trigger
CREATE DEFINER=`root`@`localhost` TRIGGER `smartFarm`.`Sensor_AFTER_INSERT` AFTER INSERT ON `Sensor` FOR EACH ROW
BEGIN
IF (SELECT Sensor_Id FROM Sensor WHERE Sensor_Id NOT IN (SELECT Sensor_Id FROM AnimalSensor) )IS NOT NULL THEN
SIGNAL SQLSTATE '45000' SET message_text='error, no animal id'; 
END IF;
END


-- check livestock id, if not exists, aborting adding animal sensor
-- add into AnimalSensor's table after insert trigger
CREATE DEFINER = `root`@`localhost` TRIGGER `smartFarm`.`AnimalSensor_AFTER_INSERT` AFTER INSERT ON `AnimalSensor` FOR EACH ROW
BEGIN
IF(SELECT Livestock_Id FROM AnimalSensor WHERE Livestock_Id NOT IN
(SELECT Id FROM Livestock)) IS NOT NULL THEN
SIGNAL SQLSTATE '45000' SET message_text='error, no animal id'; 
END IF; 

IF(SELECT Sensor_Id FROM AnimalSensor WHERE Sensor_Id IN 
(SELECT Sensor_Id FROM AnimalSensor GROUP BY Sensor_Id HAVING COUNT(Sensor_Id)>1))IS NOT NULL THEN
SIGNAL SQLSTATE '45000' SET message_text='error,duplicated sensorId'; 
END IF; 
END



-- events------------------------------------------------------------


-- automatic update livestock's age every year

SET GLOBAL event_scheduler=ON;
delimiter |
CREATE EVENT IF NOT EXISTS update_age
ON SCHEDUlE EVERY 1 YEAR
DO BEGIN
UPDATE Cow, Pig, Livestock
SET Cow.Age=Cow.Age+1, Pig.Age=Pig.Age+1, Livestock.Age=Livestock.Age+1;
END |
delimiter ;



-- check sensor, insert into Alert table if it is anomalous

SET GLOBAL event_scheduler=ON;
delimiter |
CREATE EVENT IF NOT EXISTS check_sensor
ON SCHEDULE EVERY 10 SECOND
DO BEGIN

-- check cow's temperature
INSERT INTO Alert (Sensor_Id,Time, Possible_Event)
SELECT TempSensorRecord.Sensor_Id, TempSensorRecord.Ts_Time, "fever" FROM TempSensorRecord 
INNER JOIN AnimalSensor on TempSensorRecord.Sensor_Id=AnimalSensor.Sensor_Id 
WHERE TempSensorRecord.Ts_Read>39 AND AnimalSensor.Livestock_Id IN (SELECT Id FROM Cow)
AND TempSensorRecord.Ts_Time > date_sub(now(), interval 10 second); 

-- check pig's temperature
INSERT INTO Alert (Sensor_Id,Time, Possible_Event)
SELECT TempSensorRecord.Sensor_Id, TempSensorRecord.Ts_Time, "fever" FROM TempSensorRecord 
INNER JOIN AnimalSensor on TempSensorRecord.Sensor_Id=AnimalSensor.Sensor_Id 
WHERE TempSensorRecord.Ts_Read>40 AND AnimalSensor.Livestock_Id IN (SELECT Id FROM Pig)
AND TempSensorRecord.Ts_Time > date_sub(now(), interval 10 second); 


-- check if livestock laziness
INSERT INTO Alert (Sensor_Id,Time, Possible_Event)
SELECT Sensor_Id, As_Time, "laziness" FROM AccelerationSensorRecord 
WHERE As_Read<2 
AND As_Time > date_sub(now(), interval 10 second); 

-- check if livestock in estrous
INSERT INTO Alert (Sensor_Id,Time, Possible_Event)
SELECT Sensor_Id, As_Time, "estrous" FROM AccelerationSensorRecord 
WHERE As_Read>4
AND As_Time > date_sub(now(), interval 10 second); 

END |

show processlist;
 


-- stored procedure----------------------------------------------



-- get disease history by doctor id
USE `smartFarm`;
DROP procedure IF EXISTS `getDiseaseHistoryByDoctorId`;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiseaseHistoryByDoctorId`(IN Doctor_Id INT(11))
BEGIN
  SELECT * FROM Disease_History WHERE Doctor_Id=Doctor_Id;
END$$
DELIMITER ;


-- get disease by region
USE `smartFarm`;
DROP procedure IF EXISTS `getDiseaseByRegion`;
DELIMITER $$
USE `smartFarm`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getDiseaseByRegion`(IN Region CHAR(20))
BEGIN
  SELECT * FROM Disease WHERE Region=Region;
END$$
DELIMITER ;


-- get now cured cows
USE `smartFarm`;
DROP procedure IF EXISTS `getCowNotCured`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getCowNotCured` ()
BEGIN
SELECT * FROM Cow WHERE Id IN
( SELECT Livestock_Id FROM Disease_History WHERE Cured_or_Not="not");
END$$

DELIMITER ;


-- get not cured pigs
USE `smartFarm`;
DROP procedure IF EXISTS `getPigNotCured`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getPigNotCured` ()
BEGIN
SELECT * FROM Pig WHERE Id IN
( SELECT Livestock_Id FROM Disease_History WHERE Cured_or_Not="not");
END$$

DELIMITER ;

-- get not cured livestocks
USE `smartFarm`;
DROP procedure IF EXISTS `getLivestockNotCured`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getLivestockNotCured` ()
BEGIN
SELECT * FROM Livestock WHERE Id IN
( SELECT Livestock_Id FROM Disease_History WHERE Cured_or_Not="not");
END$$

DELIMITER ;


-- list all sensor information in (sensor id, livestock id, sensor type)
USE `smartFarm`;
DROP procedure IF EXISTS `showAllSensorInfo`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `showAllSensorInfo` ()
BEGIN
select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor 
inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id ;
END$$

DELIMITER ;


-- search all sensor information by sensor id
USE `smartFarm`;
DROP procedure IF EXISTS `showSensorInfoBySensorId`;

DELIMITER $$
USE `smartFarm`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `showSensorInfoBySensorId`(IN Sensor_Id INT(11))
BEGIN
select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor 
inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id where Sensor.Sensor_Id=Sensor_Id;
END$$

DELIMITER ;


-- search all sensor information by livestock id
USE `smartFarm`;
DROP procedure IF EXISTS `showSensorInfoByLivestockId`;

DELIMITER $$
USE `smartFarm`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `showSensorInfoByLivestockId`(IN Livestock_Id INT(11))
BEGIN
select Sensor.Sensor_Id, Sensor.Sensor_Type, AnimalSensor.Livestock_Id from Sensor 
inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id where AnimalSensor.Livestock_Id=Livestock_Id;
END$$

DELIMITER ;


-- get all temp sensor result
USE `smartFarm`;
DROP procedure IF EXISTS `getTempSensorResult`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getTempSensorResult` ()
BEGIN
SELECT smartFarm.tempsensorrecord.Sensor_Id,Ts_Time,Ts_Read,Sensor_Type,Livestock_Id FROM smartFarm.tempsensorrecord join smartFarm.sensor on smartFarm.tempsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id;
END$$

DELIMITER ;


-- get all temp sensor result by livestockId
USE `smartFarm`;
DROP procedure IF EXISTS `getTempSensorResultByLivestockId`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getTempSensorResultByLivestockId` (IN Livestock_Id INT(11))
BEGIN
SELECT smartFarm.tempsensorrecord.Sensor_Id,Ts_Time,Ts_Read,Sensor_Type,Livestock_Id FROM smartFarm.tempsensorrecord join smartFarm.sensor on smartFarm.tempsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id where smartFarm.animalsensor.Livestock_Id = Livestock_Id;
END$$

DELIMITER ;

-- get all milk sensor result
USE `smartFarm`;
DROP procedure IF EXISTS `getMilkSensorResult`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getMilkSensorResult` ()
BEGIN
SELECT smartFarm.milksensorrecord.Sensor_Id,Ms_Time,Ms_Read,Sensor_Type,Livestock_Id FROM smartFarm.milksensorrecord join smartFarm.sensor on smartFarm.milksensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id;
END$$

DELIMITER ;

-- get all milk sensor result by livestockId
USE `smartFarm`;
DROP procedure IF EXISTS `getMilkSensorResultByLivestockId`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getMilkSensorResultByLivestockId` (IN Livestock_Id INT(11))
BEGIN
SELECT smartFarm.milksensorrecord.Sensor_Id,Ms_Time,Ms_Read,Sensor_Type,Livestock_Id FROM smartFarm.milksensorrecord join smartFarm.sensor on smartFarm.milksensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id where smartFarm.animalsensor.Livestock_Id = Livestock_Id;
END$$

DELIMITER ;


-- get all weight sensor result
USE `smartFarm`;
DROP procedure IF EXISTS `getWeightSensorResult`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getWeightSensorResult` ()
BEGIN
SELECT smartFarm.weightsensorrecord.Sensor_Id,Ws_Time,Ws_Read,Sensor_Type,Livestock_Id FROM smartFarm.weightsensorrecord join smartFarm.sensor on smartFarm.weightsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id;
END$$

DELIMITER ;

-- get all weight sensor result by livestockId
USE `smartFarm`;
DROP procedure IF EXISTS `getWeightSensorResultByLivestockId`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getWeightSensorResultByLivestockId` (IN Livestock_Id INT(11))
BEGIN
SELECT smartFarm.weightsensorrecord.Sensor_Id,Ws_Time,Ws_Read,Sensor_Type,Livestock_Id FROM smartFarm.weightsensorrecord join smartFarm.sensor on smartFarm.weightsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id where smartFarm.animalsensor.Livestock_Id = Livestock_Id;
END$$

DELIMITER ;

-- get all acce sensor result
USE `smartFarm`;
DROP procedure IF EXISTS `getAcceSensorResult`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getAcceSensorResult` ()
BEGIN
SELECT smartFarm.accelerationsensorrecord.Sensor_Id,As_Time,As_Read,Sensor_Type,Livestock_Id FROM smartFarm.accelerationsensorrecord join smartFarm.sensor on smartFarm.accelerationsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id;
END$$

DELIMITER ;

-- get all weight sensor result by livestockId
USE `smartFarm`;
DROP procedure IF EXISTS `getAcceSensorResultByLivestockId`;

DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getAcceSensorResultByLivestockId` (IN Livestock_Id INT(11))
BEGIN
SELECT smartFarm.accelerationsensorrecord.Sensor_Id,As_Time,As_Read,Sensor_Type,Livestock_Id FROM smartFarm.accelerationsensorrecord join smartFarm.sensor on smartFarm.accelerationsensorrecord.Sensor_Id =  smartFarm.sensor.Sensor_Id
join smartFarm.animalsensor on smartFarm.sensor.Sensor_Id = smartFarm.animalsensor.Sensor_Id where smartFarm.animalsensor.Livestock_Id = Livestock_Id;
END$$

DELIMITER ;


-- get all alert result
USE `smartFarm`;
DROP procedure IF EXISTS `getAlertResult`;
 
DELIMITER $$
USE `smartFarm`$$
CREATE PROCEDURE `getAlertResult` ()
BEGIN
SELECT smartFarm.alert.Sensor_Id, Time,  Possible_Event,Sensor_Type,Livestock_Id FROM smartFarm.alert join smartFarm.sensor on smartFarm.alert.Sensor_Id = smartFarm.sensor.Sensor_Id 
join smartFarm.animalsensor on smartFarm.alert.Sensor_Id = smartFarm.animalsensor.Sensor_Id;
END$$
 
DELIMITER ;




-- view--------------------------------------------------


-- show relation between sensor and livestock
USE `smartFarm`;
CREATE  OR REPLACE VIEW `sensorInformation` AS
select AnimalSensor.Livestock_Id,Sensor.Sensor_Id, Sensor.Sensor_Type from Sensor 
inner join AnimalSensor on Sensor.Sensor_Id=AnimalSensor.Sensor_Id
order by AnimalSensor.Livestock_Id;;


-- show alert in 24 hours
USE `smartFarm`;
CREATE  OR REPLACE VIEW `alertToday` AS
SELECT smartFarm.alert.Sensor_Id, Time,  Possible_Event,Sensor_Type,Livestock_Id FROM smartFarm.alert 
join smartFarm.sensor on smartFarm.alert.Sensor_Id = smartFarm.sensor.Sensor_Id 
join smartFarm.animalsensor on smartFarm.alert.Sensor_Id = smartFarm.animalsensor.Sensor_Id
where Time>date_sub(now(), interval 1 day);;






