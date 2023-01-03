CREATE TABLE Answers
(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    questionID INT,
    answer  varchar(100) not null ,

    FOREIGN KEY (questionID)  REFERENCES Questions (Id)
);