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
INSERT INTO Questions(quizID, title) values (1 , 'выберите любимый цвет');
INSERT INTO Questions(quizID, title) values (1 , 'выберите нелюбимый цвет');
INSERT INTO Questions(quizID, title) values (2 , 'выберите любимое число');
INSERT INTO Questions(quizID, title) values (2 , 'выберите нелюбимое число');
/**
  ответы
 */
INSERT INTO Answers(questionID, answer) values (1 , 'красный');
INSERT INTO Answers(questionID, answer) values (1 , 'синий');
INSERT INTO Answers(questionID, answer) values (2 , 'белый');
INSERT INTO Answers(questionID, answer) values (2 , 'черный');

INSERT INTO Answers(questionID, answer) values (3 , 'один');
INSERT INTO Answers(questionID, answer) values (3 , 'два');
INSERT INTO Answers(questionID, answer) values (4 , 'пять');
INSERT INTO Answers(questionID, answer) values (4 , 'шесть');
/**
  результат опроса user: анкета "color", любимый цвет - синий
  нелюбимый - черный
 */
INSERT INTO quizresult(personId, quizId, questionId, answerId) values ( 2, 1, 1, 2 );
INSERT INTO quizresult(personId, quizId, questionId, answerId) values ( 2, 1, 2, 2 );














