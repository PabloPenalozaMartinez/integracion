CREATE TABLE "User" (
    id int PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    created timestamp NOT NULL,
    modified timestamp NOT NULL,
    last_login timestamp NOT NULL,
    token varchar(100) NOT NULL,
    is_active boolean NOT NULL
);

CREATE TABLE Phone (
    id int PRIMARY KEY,
    number number NOT NULL,
    citycode number NOT NULL,
    contrycode number NOT NULL    
);