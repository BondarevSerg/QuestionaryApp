/**
  пароль - admin
 */
insert into person( login, firstName, lastName, password) VALUES
    ('admin','adminfirstname','adminlastname', '$2a$12$4BNM93Z6iqEh2mPmJh98F.9LWqWmWPxGUHhf9cMQL/G0rV21LNhCy');

/**
  пароль - user
 */
insert into person( login, firstName, lastName, password) VALUES
    ('user','userfirstname','userlastname', '$2a$12$v2ohXwcfp5nK0g9LRPxSrOZuf5oEUBMRbzP4E.vRJGYaFfD8SY6Lq');


INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO person_roles values (1 , 2);
INSERT INTO person_roles values (1 , 1);
INSERT INTO person_roles values (2 , 1);

/*
  анкеты
 */
INSERT INTO quizes(title) values ('colors');
INSERT INTO quizes(title) values ('numbers');
 /**
   вопросы
  */
INSERT INTO Questions(quizID, title) values (1 , 'your favorite color of the two');
INSERT INTO Questions(quizID, title) values (1 , 'your least favorite color of the two');
INSERT INTO Questions(quizID, title) values (2 , 'your favorite number of the two');
INSERT INTO Questions(quizID, title) values (2 , 'your least favorite number of the two');
/**
  ответы
 */
INSERT INTO Answers(questionID, answer) values (1 , 'red');
INSERT INTO Answers(questionID, answer) values (1 , 'blue');
INSERT INTO Answers(questionID, answer) values (2 , 'white');
INSERT INTO Answers(questionID, answer) values (2 , 'black');

INSERT INTO Answers(questionID, answer) values (3 , 'one');
INSERT INTO Answers(questionID, answer) values (3 , 'two');
INSERT INTO Answers(questionID, answer) values (4 , 'five');
INSERT INTO Answers(questionID, answer) values (4 , 'six');
/**
  результат опроса user: анкета "color", любимый цвет - синий
 */
INSERT INTO quizresult(personId, quizId, questionId, answerId) values ( 2, 1, 1, 2 );














