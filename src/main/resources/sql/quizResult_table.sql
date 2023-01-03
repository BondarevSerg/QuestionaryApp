
CREATE TABLE quizResult
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    personId int not null ,
    quizId  int not null ,
    questionId int not null,
    answerId int not null,

    FOREIGN KEY (personId)  REFERENCES person (id),
    FOREIGN KEY (quizId)  REFERENCES quizes (id),
    FOREIGN KEY (questionId)  REFERENCES questions (id),
    FOREIGN KEY (answerId)  REFERENCES answers (id)
);