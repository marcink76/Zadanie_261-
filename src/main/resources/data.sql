INSERT INTO USER(username, password, enabled) values ('admin', 'admin', true);
INSERT INTO USER(username, password, enabled) values ('user', 'user', true);
INSERT INTO USER(username, password, enabled) values ('marcin', 'marcin', true);
INSERT INTO USER(username, password, enabled) values ('tomek', 'tomek', true);
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('tomek', 'ROLE_MODERATOR');
INSERT INTO USER_ROLE(username, role) values ('marcin', 'ROLE_ADMIN');