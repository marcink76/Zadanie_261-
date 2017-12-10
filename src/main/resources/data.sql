INSERT INTO USER(username, password, enabled, role) values ('admin', 'admin', true, 'ROLE_ADMIN');
INSERT INTO USER(username, password, enabled, role) values ('user', 'user', true,'ROLE_ADMIN');
INSERT INTO USER(username, password, enabled, role) values ('marcin', 'marcin', true, 'ROLE_ADMIN');
INSERT INTO USER(username, password, enabled, role) values ('tomek', 'tomek', true, 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('admin', 'ROLE_ADMIN');
INSERT INTO USER_ROLE(username, role) values ('user', 'ROLE_USER');
INSERT INTO USER_ROLE(username, role) values ('tomek', 'ROLE_MODERATOR');
INSERT INTO USER_ROLE(username, role) values ('marcin', 'ROLE_ADMIN');