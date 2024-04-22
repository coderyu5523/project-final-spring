//유저
INSERT INTO user_tb(username, password, phone, name, birth, gender, height, user_img, total_coin, goalMuscle, goalFat, created_at)
VALUES ('ssar', '1234', '010-0100-0100', '김백미', '1994-04-22', 'F', 178.5, null, 500, 35.0, 12.0,now());

//활동
INSERT INTO activity_tb(user_id, walking,drink_water,created_at) VALUES (1,2222,500,now());

//바디
INSERT INTO body_tb(user_id, weight, muscle, fat, created_at) VALUES (1,75.8,27.6,20.1,500,now());