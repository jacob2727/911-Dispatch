CREATE TABLE archived_calls
(
    id              UUID NOT NULL,
    call_type       VARCHAR(255),
    address         VARCHAR(255),
    urgency         VARCHAR(255),
    responding_unit VARCHAR(255),
    notes           VARCHAR(255),
    CONSTRAINT pk_archivedcalls PRIMARY KEY (id)
);