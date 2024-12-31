CREATE SCHEMA `speedoh`;
USE `speedoh`;

CREATE TABLE IF NOT EXISTS `drivers`(
    driver_id INT auto_increment PRIMARY KEY,
    driver_name NVARCHAR(255) NOT NULL,
    driver_license NVARCHAR(255) NOT NULL,
    driver_phone NVARCHAR(15),
    driver_email NVARCHAR(255),
    password VARCHAR(500),
    driver_address NVARCHAR(500),
    driver_license_image NVARCHAR(500),
    driver_image NVARCHAR(500)
);

CREATE TABLE IF NOT EXISTS `vehicles`(
    vehicle_id INT auto_increment PRIMARY KEY,
    vehicle_name NVARCHAR(255) NOT NULL,
    vehicle_type NVARCHAR(255) NOT NULL,
    vehicle_number NVARCHAR(50) NOT NULL,
    vehicle_image NVARCHAR(500),
    vehicle_image_url NVARCHAR(500)
);
