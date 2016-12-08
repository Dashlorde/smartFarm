-- Create tables section -------------------------------------------------

-- Table Livestock

CREATE TABLE `Livestock` (
    `Id` INT NOT NULL,
    `Employee_Id` INT(11),
    `Age` INT NOT NULL,
    `Weight` INT NOT NULL,
    `Gender` CHAR(20) NOT NULL,
    
    PRIMARY KEY (`Id`)
)
;

CREATE INDEX `IX_Relationship2` ON `Livestock` (`Employee_Id`)
;


-- Table Employee

CREATE TABLE `Employee`
(
  `Id` Int(11) NOT NULL,
  `Name` Char(20) NOT NULL,
  `Phone` Char(20) NOT NULL,
  `Category` Char(20) NOT NULL,
	`Password` Char(20) NOT NULL
)
;

ALTER TABLE `Employee` ADD  PRIMARY KEY (`Id`)
;


-- Table Cow

CREATE TABLE `Cow`
(
  `Id` Int NOT NULL,
  `Employee_Id` INT(11),
	`Age` INT NOT NULL,
    `Weight` INT NOT NULL,
    `Gender` CHAR(20) NOT NULL,
  `Milk_Production` Char(20)
)
;

ALTER TABLE `Cow` ADD  PRIMARY KEY (`Id`)
;

-- Table Pig

CREATE TABLE `Pig`
(
  `Id` Int NOT NULL,
  `Employee_Id` INT(11),
    `Age` INT NOT NULL,
    `Weight` INT NOT NULL,
    `Gender` CHAR(20) NOT NULL
)
;

ALTER TABLE `Pig` ADD  PRIMARY KEY (`Id`)
;

-- Table Quarantine

CREATE TABLE `Quarantine`
(
  `Time` Datetime(0) NOT NULL,
  `Livestock_Id` Int NOT NULL,
  `Epidemic` Char(20) NOT NULL,
  `Location` Char(20) NOT NULL,
  `Status` Char(20) NOT NULL
)
;

ALTER TABLE `Quarantine` ADD  PRIMARY KEY (`Time`,`Livestock_Id`)
;

-- Table Vaccine_Record

CREATE TABLE `Vaccine_Record`
(
  `Vaccine_Id` Int NOT NULL,
  `Livestock_Id` Int NOT NULL,
  `Last_Vaccine_Date` Date NOT NULL,
  `Next_Vaccine_Date` Datetime NOT NULL
)
;

ALTER TABLE `Vaccine_Record` ADD  PRIMARY KEY (`Livestock_Id`,`Vaccine_Id`)
;

-- Table Vaccine

CREATE TABLE `Vaccine`
(
  `Vaccine_Id` Int NOT NULL,
  `Name` Char(20) NOT NULL,
  `Disease_Pevent` Char(20) NOT NULL,
  `Group` Char(20) NOT NULL,
  `Vaccine_Age` Char(20) NOT NULL,
  `Immune_Period` Char(20) NOT NULL
)
;

ALTER TABLE `Vaccine` ADD  PRIMARY KEY (`Vaccine_Id`)
;

-- Table Disease_History

CREATE TABLE `Disease_History`
(
  `Livestock_Id` Int NOT NULL,
  `Diagnosis_Date` Date NOT NULL,
  `Disease_Id` Int NOT NULL,
  `Doctor_Id` Int,
  `Cured_or_Not` Char(20) NOT NULL
)
;

CREATE INDEX `IX_Relationship12` ON `Disease_History` (`Doctor_Id`)
;

ALTER TABLE `Disease_History` ADD  PRIMARY KEY (`Diagnosis_Date`,`Livestock_Id`,`Disease_Id`)
;

-- Table Disease

CREATE TABLE `Disease`
(
  `Id` Int NOT NULL,
  `Name` Char(20) NOT NULL,
  `Description` Char(20) NOT NULL,
  `Cure` Char(20),
  `Region` Char(20) NOT NULL
)
;

ALTER TABLE `Disease` ADD  PRIMARY KEY (`Id`)
;

-- Table Doctor

CREATE TABLE `Doctor`
(
  `Id` Int NOT NULL,
  `Name` Char(20) NOT NULL,
  `Phone` Char(20) NOT NULL,
  `Speciaty` Char(20) NOT NULL,
  `Password` Char(20) NOT NULL
)
;

ALTER TABLE `Doctor` ADD  PRIMARY KEY (`Id`)
;

-- Table Feed_Record

CREATE TABLE `Feed_Record`
(
  `Livestock_Id` Int NOT NULL,
  `Time` Datetime NOT NULL,
  `Quantity` Decimal(10,0) NOT NULL,
  `Feed` Char(20) NOT NULL
)
;

ALTER TABLE `Feed_Record` ADD  PRIMARY KEY (`Time`,`Livestock_Id`)
;

-- Table Alert

CREATE TABLE `Alert`
(
  `Sensor_Id` Int NOT NULL,
  `Time` Datetime NOT NULL,
  `Possible_Event` Char(20) NOT NULL
)
;

ALTER TABLE `Alert` ADD  PRIMARY KEY (`Time`,`Sensor_Id`)
;

CREATE TABLE `AnimalSensor` (
  `Livestock_Id` int(11) NOT NULL,
  `Sensor_Id` int(11) NOT NULL,
  PRIMARY KEY (`Livestock_Id`,`Sensor_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Sensor` (
  `Sensor_Id` int(11) NOT NULL,
  `Sensor_Type` char(20) NOT NULL,
  PRIMARY KEY (`Sensor_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `TempSensorRecord` (
  `Sensor_Id` int(11) NOT NULL,
  `Ts_Time` datetime NOT NULL,
  `Ts_Read` double DEFAULT NULL,
  PRIMARY KEY (`Sensor_Id`,`Ts_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `AccelerationSensorRecord` (
  `Sensor_Id` int(11) NOT NULL,
  `As_Time` datetime NOT NULL,
  `As_Read` double DEFAULT NULL,
  PRIMARY KEY (`Sensor_Id`,`As_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
CREATE TABLE `WeightSensorRecord` (
  `Sensor_Id` int(11) NOT NULL,
  `Ws_Time` datetime NOT NULL,
  `Ws_Read` double DEFAULT NULL,
  PRIMARY KEY (`Sensor_Id`,`Ws_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
CREATE TABLE `MilkSensorRecord` (
  `Sensor_Id` int(11) NOT NULL,
  `Ms_Time` datetime NOT NULL,
  `Ms_Read` double DEFAULT NULL,
  PRIMARY KEY (`Sensor_Id`,`Ms_Time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `smartFarm`.`AnimalSensor` 
ADD INDEX `sensorFK_idx` (`Sensor_Id` ASC);
ALTER TABLE `smartFarm`.`AnimalSensor` 
ADD CONSTRAINT `livestockFK`
  FOREIGN KEY (`Livestock_Id`)
  REFERENCES `smartFarm`.`Cow` (`Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `sensorFK`
  FOREIGN KEY (`Sensor_Id`)
  REFERENCES `smartFarm`.`Sensor` (`Sensor_Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

-- this one can not add, (foreign key constrain)
ALTER TABLE `smartFarm`.`TempSensorRecord` 
ADD CONSTRAINT `temp`
  FOREIGN KEY (`Sensor_Id`)
  REFERENCES `smartFarm`.`Sensor` (`Sensor_Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `smartFarm`.`WeightSensorRecord` 
ADD CONSTRAINT `weight`
  FOREIGN KEY (`Sensor_Id`)
  REFERENCES `smartFarm`.`Sensor` (`Sensor_Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `smartFarm`.`MilkSensorRecord` 
ADD CONSTRAINT `milk`
  FOREIGN KEY (`Sensor_Id`)
  REFERENCES `smartFarm`.`Sensor` (`Sensor_Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `smartFarm`.`AccelerationSensorRecord` 
ADD CONSTRAINT `acc`
  FOREIGN KEY (`Sensor_Id`)
  REFERENCES `smartFarm`.`Sensor` (`Sensor_Id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


