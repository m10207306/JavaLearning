INSERT INTO user_details (id, birth_date, name) VALUES (10001, CURRENT_DATE(), 'Ranga')
INSERT INTO user_details (id, birth_date, name) VALUES (10002, CURRENT_DATE(), 'Ravi')
INSERT INTO user_details (id, birth_date, name) VALUES (10003, CURRENT_DATE(), 'Sathish')

INSERT INTO post (id, description, user_id) VALUES (20001, 'I want to learn AWS', 10001)
INSERT INTO post (id, description, user_id) VALUES (20002, 'I want to learn DevOps', 10001)
INSERT INTO post (id, description, user_id) VALUES (20003, 'I want to Get AWS Certified', 10002)
INSERT INTO post (id, description, user_id) VALUES (20004, 'I want to learn Multi Cloud', 10002)