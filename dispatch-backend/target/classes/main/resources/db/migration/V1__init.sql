CREATE TABLE active_calls
(
    id                   UUID NOT NULL,
    call_type            VARCHAR(255),
    address              VARCHAR(255),
    urgency              VARCHAR(255),
    responding_unit      VARCHAR(255),
    response_minuets_eta INTEGER,
    CONSTRAINT pk_activecalls PRIMARY KEY (id)
);