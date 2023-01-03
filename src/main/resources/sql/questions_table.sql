CREATE TABLE Questions
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    quizID INT,
    question  varchar(100) not null ,

    FOREIGN KEY (quizID)  REFERENCES quizes (Id)
);