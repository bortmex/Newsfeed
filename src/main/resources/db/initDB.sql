DROP TABLE IF EXISTS newsfeed;
DROP TABLE IF EXISTS categories;
DROP SEQUENCE IF EXISTS global_seq;

create sequence global_seq start 100000;

CREATE TABLE categories
(   id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR not null
);

CREATE TABLE newsfeed
(   id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR not null,
    content         VARCHAR not null,
    datacreate      TIMESTAMP DEFAULT now(),
    categories_id   INTEGER NOT NULL,
    FOREIGN KEY (categories_id) REFERENCES categories (id) ON DELETE CASCADE
);


