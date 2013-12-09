create table MEASUREMENTS(
    
    ID integer not null,
    NAME VARCHAR(20) NOT NULL,
    AMOUNT_G INTEGER NOT NULL,
    PRIMARY KEY(ID)

);

create table INGREDIENTS(
    
    ID integer not null,
    NAME VARCHAR(20) NOT NULL,
    G_SOLD INTEGER,
    IND_DIVISIBLE BOOLEAN,
    PRIMARY KEY(ID)
);

create table RECIPES(
    
    ID integer not null,
    NAME VARCHAR(20) NOT NULL,
    NUM_OF_SERVINGS INTEGER,
    NOTES VARCHAR(1000),
    PRIMARY KEY(ID)
);

create table ING_TO_RECIPE(
    
    RECIPE_ID integer not null,
    ING_ID INTEGER NOT NULL,
    AMOUNT_G INTEGER NOT NULL,
    PRIMARY KEY(RECIPE_ID, ING_ID)
);