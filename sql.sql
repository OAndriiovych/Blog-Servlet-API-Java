 CREATE TYPE roles AS enum ('user', 'admin', 'moderator');

CREATE TABLE users
  (
     id_user     SERIAL PRIMARY KEY,
     login       VARCHAR(26) NOT NULL UNIQUE,
     passw       VARCHAR(64) NOT NULL,
     lastname    VARCHAR(30) NOT NULL,
     date_of_reg DATE DEFAULT CURRENT_TIMESTAMP,
     way_to_photo TEXT DEFAULT '\images\deff.jpg',
     user_role   ROLES DEFAULT 'user'
  );

CREATE TABLE user_comments
  (
     id_comment     SERIAL PRIMARY KEY,
     user_id        INTEGER NOT NULL,
     post_id        INTEGER NOT NULL,
     user_comment   TEXT NOT NULL,
     date_of_coment DATE DEFAULT CURRENT_TIMESTAMP
  );

CREATE TABLE posts
  (
     id_post        SERIAL PRIMARY KEY,
     category       VARCHAR(15) NOT NULL,
     topic          VARCHAR(40) NOT NULL,
     post           TEXT NOT NULL,
     way_to_photo   TEXT,
     user_id        INTEGER NOT NULL,
     date_of_post   DATE DEFAULT CURRENT_TIMESTAMP
  );

ALTER TABLE user_comments
  ADD CONSTRAINT cs_cmmnt_u FOREIGN KEY (user_id) REFERENCES users(id_user);

ALTER TABLE user_comments
  ADD CONSTRAINT cs_cmmnt_p FOREIGN KEY (post_id) REFERENCES posts(id_post);

ALTER TABLE posts
  ADD CONSTRAINT cs_posts FOREIGN KEY (user_id) REFERENCES users(id_user);