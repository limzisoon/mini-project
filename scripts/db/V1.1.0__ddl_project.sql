CREATE TABLE restaurant (
    id integer NOT NULL,
    code varchar(20)  NOT NULL,
    name varchar(100) NOT NULL,
    address  varchar(250) NULL
);

INSERT INTO restaurant (id, code, name, address) VALUES (1, 'R001', 'Kopitiam', '108 Punggol Fld, #01-01, 820108 Singapore');
INSERT INTO restaurant (id, code, name, address) VALUES (2, 'R002', 'FoodPark', '69 Bedok South Avenue 3, 460069 Singapore');
INSERT INTO restaurant (id, code, name, address) VALUES (3, 'R003', 'Koufu', '168 Punggol Fld, #01-01 Punggol Plaza, 820168 Singapore');
INSERT INTO restaurant (id, code, name, address) VALUES (4, 'R004', 'S11', '504 Bishan Street 11, #01-444, 570504 Singapore');
INSERT INTO restaurant (id, code, name, address) VALUES (5, 'R005', 'KFC Restaurant', '11 Rivervale Crescent, #01-36, Rivervale Mall, 545082 Singapore');

CREATE TABLE Lunch (
    id integer  NULL,
    created_by varchar(250)  NULL,
    created_time timestamp NOT NULL DEFAULT now(),
    last_updated_time timestamp NOT NULL DEFAULT now(),
    description varchar(250) NULL,
    status varchar(30) NULL,
    picked_restaurant_cd varchar(30) NULL
);

CREATE TABLE member (
    id integer  NULL,
    name varchar(250)  NULL,
    lunch_id integer NULL,
    restaurant_cd varchar(30) NULL
);



