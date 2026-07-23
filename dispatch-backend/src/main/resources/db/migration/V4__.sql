CREATE TABLE "user"
(
    id          VARCHAR(255) NOT NULL,
    email       VARCHAR(255) NOT NULL,
    name        VARCHAR(255),
    picture     VARCHAR(255),
    roles       TEXT[],

    CONSTRAINT pk_user PRIMARY KEY (id)
);

